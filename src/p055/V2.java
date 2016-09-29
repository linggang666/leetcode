package p055;

public class V2 {
	
	/**
	 * Time Limit Exceeded 
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int maxIndex = 0;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]==0 && maxIndex <= i) return false;
			maxIndex = Math.max(maxIndex, i+nums[i]);
		}
		return true;
	}

	
	public static void main(String[] args) {
//		int[] a = { 2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2,
//				4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9,
//				0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9,
//				6 };
//		int[] a = {2,3,1,1,4};
//		int[] a = {2,1,0,4};
		int[] a = {0};
		V2 v = new V2();
		System.out.println(v.canJump(a));
	}
}
