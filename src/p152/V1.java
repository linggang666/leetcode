package p152;

public class V1 {
	public int maxProduct(int[] nums) {
		if(nums == null || nums.length==0) return 0;
		if(nums.length == 1) return nums[0];
		
		int max = nums[0];
		int curMax = nums[0];
		int curMin = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int a = Math.max(nums[i], Math.max(curMax*nums[i], curMin*nums[i]));
			int b = Math.min(nums[i], Math.min(curMax*nums[i], curMin*nums[i]));
			curMax = a;
			curMin = b;
			max = Math.max(max, curMax);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,6,-1,7,-1,2,4};
		V1 v = new V1();
		System.out.println(v.maxProduct(a));
	}
}
