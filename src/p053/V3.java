package p053;

public class V3 {
	
	/**
	 * dp
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(nums==null||nums.length==0) return Integer.MIN_VALUE;
		
		int[] dp = new int[nums.length];
		int max = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
			max = Math.max(max, dp[i]);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {-2,-1,-3,4,-1,2,-1,-5,-4};
		V3 v = new V3();
		System.out.println(v.maxSubArray(a));
	}
}
