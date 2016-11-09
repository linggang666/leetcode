package p096;

public class V1 {
	
	public int numTrees(int n) {
		if(n<2) return n;
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <=n ; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[j-1] * dp[i-j];
			}
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.numTrees(8));
		System.out.println(v.numTrees(6)); //132
		System.out.println(v.numTrees(5)); //42
	}
}
