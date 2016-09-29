package p169;

import java.util.Arrays;

public class V1 {
	public int majorityElement(int[] nums) {
		
		Arrays.sort(nums);
        return nums[nums.length/2];
	}
}
