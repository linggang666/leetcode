package p053;

public class V2 {
	
	/**
	 * 分治
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		if(nums==null || nums.length==0) return Integer.MIN_VALUE;
		return _maxSubArray(nums, 0, nums.length-1);
	}
	
	private int _maxSubArray(int[] nums, int l, int r) {
		if(l==r) return nums[l];
		
		int m = l+(r-l)/2;
		int lSum = _maxSubArray(nums, l, m);
		int rSum = _maxSubArray(nums, m+1, r);
		
		int curSum=0, tempLeftSum = Integer.MIN_VALUE,tempRightSum=Integer.MIN_VALUE;
		for (int i = m; i>=l; i--) {
			curSum += nums[i];
			tempLeftSum = Math.max(tempLeftSum, curSum);
		}
		curSum=0;
		for (int i = m+1; i<=r; i++) {
			curSum += nums[i];
			tempRightSum = Math.max(tempRightSum, curSum);
		}
		
		return Math.max(tempLeftSum+tempRightSum, Math.max(lSum, rSum));
	}

	public static void main(String[] args) {
		int[] a = {-2,-1,-3,4,-1,2,-1,-5,-4};
		V2 v = new V2();
		System.out.println(v.maxSubArray(a));
	}
}
