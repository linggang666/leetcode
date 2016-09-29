package p070;

public class V3 {
	
	public int climbStairs(int n) {
		int[] dp = {1,1};
		for (int i = 2; i <= n; i++) {
			dp[i%2] = dp[0] + dp[1];
		}
		return dp[n%2]; 
	}
}
