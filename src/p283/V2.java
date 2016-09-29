package p283;

public class V2 {
	public void moveZeroes(int[] nums) {
		int len = nums.length;
		int lastNoZeroIndex = 0;
		for (int i = 0; i < len; i++) {
			if(nums[i] != 0){
				int tmp = nums[i];
				nums[i] = nums[lastNoZeroIndex];
				nums[lastNoZeroIndex++] = tmp;
			}
		}
	}
}
