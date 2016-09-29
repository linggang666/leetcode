package p213;

public class V1 {
	
	public int rob(int[] nums) {
		if(nums == null || nums.length==0) return 0;
		if(nums.length == 1) return nums[0];
		
		return Math.max(this._rob(nums, 0, nums.length-2), this._rob(nums, 1, nums.length-1));
	}
	
	private int _rob(int[] nums, int l, int r){
		int[] dp = new int[r-l+1];
		for (int i=l; i<=r && i<nums.length; i++) {
			if(i==l) 
				dp[0] = nums[i];
			else if(i==l+1){
				dp[1] = Math.max(nums[l], nums[l+1]);
			}else{
				dp[i-l] = Math.max(dp[i-l-1], dp[i-l-2]+nums[i]);
			}
		}
		return dp[r];
	}

	public static void main(String[] args) {
		int[] a = {2,3,5,78,1,3,5,7,8,3,2,41,2,4};
		V1 v = new V1();
		System.out.println(v.rob(a));
	}

}
