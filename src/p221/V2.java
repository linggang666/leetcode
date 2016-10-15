package p221;


public class V2 {
	
	/**
	 * dp
	 * @param matrix
	 * @return
	 */
	public int maximalSquare(char[][] matrix) {
		
		int rows = matrix.length, cols=rows==0?0:matrix[0].length;
		int max = 0;
		int[][] dp = new int[rows+1][cols+1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if(matrix[i-1][j-1] == '1'){
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max*max;
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
		V2 v1 = new V2();
		System.out.println(v1.maximalSquare(arr));
	}
}
