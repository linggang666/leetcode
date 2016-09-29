package p268;

public class V1 {

	public int missingNumber(int[] nums) {
		int len = nums.length;
		int r = 0;
		for (int i = 0; i < len; i++) {
			r = r^i^nums[i];
		}
		return r^=len;
	}

	public static void main(String[] args) {
		int[] a = {1,2,4,3};
		V1 v = new V1();
		System.out.println(v.missingNumber(a));
	}

}
