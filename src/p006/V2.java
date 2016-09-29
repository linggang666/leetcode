package p006;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class V2 {
	/**
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		int len = s.length();
		if(numRows < 2 || len<= numRows){
			return s;
		}
		
		Map<Integer, Map<Integer, Character>> matrix = new HashMap<>();
		for(int i=0; i<numRows; i++){
			matrix.put(i, new TreeMap<Integer, Character>());
		}
		
		int curCol = 0, curRow = 0;
		int rowStep = 1; 
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			matrix.get(curRow).put(curCol, c);
			
			curRow = curRow + rowStep;
			if(rowStep == 1){
				if(curRow == numRows){
					curCol++;
					curRow = curRow-2;
					rowStep = -1;
				}
			}else{
				if(curRow == -1){
					curRow = 1;
					rowStep = 1;
				}else{
					curCol ++;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (Map.Entry<Integer, Character> entry : matrix.get(i).entrySet()) {
				sb.append(entry.getValue());
			}
		}
		return sb.toString();

	}

	private void printMatrix(Map<Integer, Map<Integer, Character>> matrix, int numRows) {
		for (int i = 0; i < numRows; i++) {
			int count = 0;
			int index = 0;
			Map<Integer, Character> m = matrix.get(i);
			while(count < m.size()){
				if(m.containsKey(index)){
					count++;
					System.out.print(m.get(index)+"\t");
				}else{
					System.out.print(".\t");
				}
				index ++;
			}
			System.out.println();
		}
	}
	
}
