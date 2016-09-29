package p198;

public class V1 {
	public int rob(int[] nums) {
		int result = 0;
		int len = nums.length;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			if (i == 0) {
				dp[0] = nums[0];
			} else if (i == 1){
				dp[1] = Math.max(nums[0], nums[1]);
			}else{
				dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
			}
			result = Math.max(result, dp[i]);
		}

		return result;
	}
}
