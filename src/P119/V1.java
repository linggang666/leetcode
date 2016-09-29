package P119;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V1 {
	public List<Integer> getRow(int rowIndex) {
		if(rowIndex < 0) return null;
		
		List<Integer> result = new ArrayList<Integer>(rowIndex+1);
		List<Integer> temp = new ArrayList<Integer>(rowIndex+1);
		for (int i = 0; i <= rowIndex; i++) {
			result.add(1);
			temp.add(1);
		}
		
		for (int i = 0; i <= rowIndex ; i++) {
			Collections.copy(temp, result);;
			for (int j = 0; j <= i; j++) {
				if(j != 0 && j!=i){
					result.set(j,temp.get(j-1) + temp.get(j));
				}
			}
		}
		return result;
	}
}
