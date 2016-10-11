package p264;

public class V1 {

	/**
	 * use dp
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
		if(n == 1) return 1;
		
		int[] dp = new int[n];
		int[] index = new int[3];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			while(dp[index[0]]*2 <= dp[i-1]) index[0]++;
			while(dp[index[1]]*3 <= dp[i-1]) index[1]++;
			while(dp[index[2]]*5 <= dp[i-1]) index[2]++;
			
			dp[i] = Math.min(dp[index[0]]*2, Math.min(dp[index[1]]*3, dp[index[2]]*5));
			
			if(dp[i] == dp[index[0]]*2) index[0]++;
			else if(dp[i] == dp[index[1]]*3) index[1]++;
			else if(dp[i] == dp[index[2]]*5) index[2]++;
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.nthUglyNumber(12));  //16
	}

}
