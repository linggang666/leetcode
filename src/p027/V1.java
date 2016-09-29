package p027;

public class V1 {
	public int removeElement(int[] nums, int val) {

		int i = 0, j = nums.length - 1;
		while (i <= j) {
			if(nums[i] == val){
				nums[i] = nums[j--];
			}else{
				i++;
			}
		}
		return j+1;
	}
}
