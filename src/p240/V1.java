package p240;

public class V1 {

	/**
	 * 从右上角开始
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0) return false;
		
		int i=0,j = matrix[0].length-1;
		while(i<matrix.length && j>=0){
			if(matrix[i][j] == target)
				return true;
			if(matrix[i][j] > target){
				j--;
			}else{
				i++;
			}
		}
		
		return false;
	}
	
	
	public static void main(String[] args) {
		int[][] a = {
		              {1,   4,  7, 11, 15},
		              {2,   5,  8, 12, 19},
		              {3,   6,  9, 16, 22},
		              {10, 13, 14, 17, 24},
		              {18, 21, 23, 26, 30}
		            };
		
		int[][] b = {
				{-1},
				{-1}
		};
		V1 v = new V1();
		System.out.println(v.searchMatrix(b, -1));
	}

}
