package p329;

public class V1 {
	
	/**
	 * dfs + memoization
	 */
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length==0 || matrix[0].length == 0)
			return 0;
		int rows = matrix.length, cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int res = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				res = Math.max(res,getLongestPath(matrix,i,j,dp));
			}
		}
		return res;
	}

	private int getLongestPath(int[][] matrix, int i, int j, int[][] dp) {
		if(i<0||i>=matrix.length || j<0||j>=matrix[0].length){
			return 0;
		}
		if(dp[i][j] == 0){
			int max = 0;
			if(i>0 && matrix[i-1][j]>matrix[i][j]) //top
				max = Math.max(max, getLongestPath(matrix, i-1, j, dp));
			if(i<matrix.length-1 && matrix[i+1][j]>matrix[i][j])//bottom
				max = Math.max(max, getLongestPath(matrix, i+1, j, dp));
			if(j>0 && matrix[i][j-1]>matrix[i][j])//left
				max = Math.max(max, getLongestPath(matrix, i, j-1, dp));
			if(j<matrix[0].length-1 && matrix[i][j+1]>matrix[i][j])//right
				max = Math.max(max, getLongestPath(matrix, i, j+1, dp));
			dp[i][j] = max+1;
		}
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		int[][] a = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};
		V1 v = new V1();
		System.out.println(v.longestIncreasingPath(a));
	}
}
