package p075;

public class V1 {
	public void sortColors(int[] nums) {
		int[] counts = new int[3];
		for (int i : nums) {
			counts[i]++;
		}
		
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			for (int j = 0; j < counts[i]; j++) {
				nums[index++] = i;
			}
		}
	}
}
