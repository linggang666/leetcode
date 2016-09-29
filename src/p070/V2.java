package p070;

public class V2 {
	
	public int climbStairs(int n) {
		int[] dp = {0,1,2};
		for (int i = 3; i <= n; i++) {
			dp[i%3] = dp[(i-1)%3] + dp[(i-2)%3];
		}
		return dp[n%3]; 
	}
}
