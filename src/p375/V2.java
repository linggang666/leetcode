package p375;

public class V2 {
	
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 2; i <=n; i++) {
			for (int j = i-1; j >0 ; j--) {
				int min = Integer.MAX_VALUE;
				for (int k = j+1; k < i; k++) {
					int t = k + Math.max(dp[j][k-1], dp[k+1][i]);
					min = Math.min(t, min);
				}
				dp[j][i] = j+1==i?j:min;
			}
		}
		return dp[1][n];
	}
	
	public static void main(String[] args) {
		V2 v1 = new V2();
		System.out.println(v1.getMoneyAmount(5));
	}
}
