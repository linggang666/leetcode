package p053;

public class V1 {
	
	/**
	 * o(n)
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int curSum = 0;
		for (int i = 0; i < nums.length; i++) {
			curSum += nums[i];
			max = Math.max(curSum, max);
			if(curSum<0){
				curSum = 0;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {-2,-1,-3,-4,-1,-2,-1,-5,-4};
		V1 v = new V1();
		System.out.println(v.maxSubArray(a));
	}
}
