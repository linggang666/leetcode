package p221;


public class V1 {
	public int maximalSquare(char[][] matrix) {
		
		int rows = matrix.length, cols=rows==0?0:matrix[0].length;
		int max = 0;
		for (int i = 0; i < rows-max; i++) {
			for (int j = 0; j < cols-max; j++) {
				max = Math.max(max, getMax(matrix,i,j));
			}
		}
		return max*max;
	}

	private int getMax(char[][] matrix, int i, int j) {
		
		int max = 0;
		int rows = matrix.length, cols=matrix[0].length;
		while (i+max<rows && j+max<cols) {
			for (int k = 0; k <= max; k++) {
				if(matrix[i+max][j+k] == '0' || matrix[i+k][j+max] == '0') 
					return max;
			}
			max++;
		}
		return max;
	}
	
	public static void main(String[] args) {
		char[][] arr = {
				{'1','0','1','0','0','0'},
				{'1','0','1','1','1','0'},
				{'1','1','1','1','1','0'},
				{'1','0','0','1','1','0'},
				{'1','0','0','0','0','0'},
				{'1','0','0','0','0','0'}
		};
		V1 v1 = new V1();
		System.out.println(v1.maximalSquare(arr));
	}
}
