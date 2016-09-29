package p026;

public class V1 {
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		
		int b = 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[b] != nums[i]){
				nums[++b] = nums[i];
			}
		}
		return b+1;
	}
}
