package p377;

public class V1 {
	
	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target+1];
		dp[0] = 1;
		for (int i = 1; i <= target; i++) {
			for (int num :nums) {
				if(i>=num){
					dp[i] += dp[i-num];
				}
			}
		}
		return dp[target];
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		int[] a = {1,2,3};
		System.out.println(v.combinationSum4(a, 5));
	}
}
