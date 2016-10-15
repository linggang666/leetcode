package p075;

public class V2 {
	public void sortColors(int[] nums) {
		int i=0, j=0, k=0;
		for (int num : nums) {
			switch (num) {
			case 0:
				nums[k++] = 2;
				nums[j++] = 1;
				nums[i++] = 0;
				break;
			case 1:
				nums[k++] = 2;
				nums[j++] = 1;
				break;
			case 2:
				nums[k++] = 2;
				break;
			}
		}
	}
}
