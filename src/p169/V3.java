package p169;

public class V3 {
	public int majorityElement(int[] nums) {

		int majority = 0;
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (cnt == 0) {
				majority = nums[i];
				cnt++;
			} else {
				if (majority == nums[i]) {
					cnt++;
				} else {
					cnt--;
				}
				if (cnt >= nums.length / 2 + 1)
					return majority;
			}
		}
		return majority;
	}
	
	public static void main(String[] args) {
		int[] a = {3,2,4,2,2,2,2,6};
		V3 v = new V3();
		System.out.println(v.majorityElement(a));
	}
}
