package p006;

public class V1 {
	/**
	 * 题意理解错误
	 * @param s
	 * @param numRows
	 * @return
	 */
	public String convert(String s, int numRows) {
		int len = s.length();
		if(numRows < 2 || len<= numRows){
			return s;
		}
		
		int numCols = 2*(len/(numRows+1))+1;
		char[][] matrix = new char[numRows][numCols];
		int curCol = 0, curRow = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(curCol % 2 == 0){
				matrix[curRow][curCol] = c;
				curRow ++;
				if(curRow == numRows){
					curCol ++;
					curRow = 0;
				}
			}else{
				curRow = (numRows-1) / 2;
				matrix[curRow][curCol] = c;
				curCol ++;
				curRow = 0;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				if(matrix[i][j] != '\0'){
					sb.append(matrix[i][j]);
				}
				System.out.print(matrix[i][j]+"\t");
			}
			System.out.println("");
		}
		return sb.toString();

	}
	
}
