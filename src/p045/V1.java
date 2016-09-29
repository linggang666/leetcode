package p045;

import java.util.Arrays;

public class V1 {
	
	
	/**
	 * Time Limit Exceeded
	 * @param nums
	 * @return
	 */
	public int jump(int[] nums) {
		int jumps = 0;
		int pos = nums.length-1;
		while(pos > 0){
			int t = pos;
			for (int i = pos-1; i>=0; i--) {
				if(nums[i] >= pos-i) t = i;
			}
			pos = t;
			jumps++;
		}
		return jumps;
	}

	public static void main(String[] args) {
		int[] a = {2,3,5,7,8,3,2,3,1,6,3,1,3,5};
		
		int[] arr = new int[25002];
		for (int i = 0; i < 25000; i++) {
			arr[i] = 25000-i;
		}
		arr[25000] = 1;
		arr[25001] = 0;
		System.out.println(Arrays.toString(arr));
		V1 v = new V1();
		System.out.println(v.jump(arr));

	}

}
