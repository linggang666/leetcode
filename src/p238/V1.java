package p238;

import java.util.Arrays;

public class V1 {
	public int[] productExceptSelf(int[] nums) {
		
		int[] res = new int[nums.length];
		int temp = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] = temp;
			temp = temp * nums[i];
		}
		
		temp = 1;
		for (int i = nums.length-1; i >=0; i--) {
			res[i] = res[i] * temp;
			temp = temp * nums[i];
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] a = {0,1,2,3,4};
		System.out.println(Arrays.toString((new V1()).productExceptSelf(a)));
	}

}
