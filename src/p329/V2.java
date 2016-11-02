package p329;

public class V2 {
	
	/**
	 * dfs + memoization
	 */
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix.length==0 || matrix[0].length == 0)
			return 0;
		
		int rows = matrix.length, cols = matrix[0].length;
		int[][] dp = new int[rows][cols];
		int res = 0;
		for (int i = 0; i < rows; i++) 
			for (int j = 0; j < cols; j++) 
				res = Math.max(res,getLongestPath(matrix,-1,i,j,dp));
			
		return res;
	}

	private int getLongestPath(int[][] matrix,int min, int i, int j, int[][] dp) {
		if(i<0||i>=matrix.length || j<0||j>=matrix[0].length || matrix[i][j]<=min){
			return 0;
		}
		if(dp[i][j] == 0){
			int max = 0;
			max = Math.max(max, getLongestPath(matrix, matrix[i][j], i-1, j, dp));
			max = Math.max(max, getLongestPath(matrix, matrix[i][j], i+1, j, dp));
			max = Math.max(max, getLongestPath(matrix, matrix[i][j], i, j-1, dp));
			max = Math.max(max, getLongestPath(matrix, matrix[i][j], i, j+1, dp));
			dp[i][j] = max+1;
		}
		return dp[i][j];
	}
	
	public static void main(String[] args) {
		int[][] a = {
				{7,7,5},
				{2,4,6},
				{8,2,0}
		};
		V2 v = new V2();
		System.out.println(v.longestIncreasingPath(a));
	}
}
