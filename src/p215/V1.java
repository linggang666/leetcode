package p215;

import java.util.Arrays;

public class V1 {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
}
