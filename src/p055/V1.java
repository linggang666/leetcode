package p055;

public class V1 {
	
	/**
	 * Time Limit Exceeded 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		if(nums.length <= 1) return true;
		return _canJump(nums, 0);
	}

	private boolean _canJump(int[] nums, int i) {
		int lastIndex = nums.length-1;
		for (int j = nums[i]; j > 0; j--) {
			if (i+j==lastIndex || (i+j<lastIndex && _canJump(nums, i + j)))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2,
				4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9,
				0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9,
				6 };
		V1 v = new V1();
		System.out.println(v.canJump(a));
	}
}
