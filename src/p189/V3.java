package p189;

import java.util.Arrays;

public class V3 {
	public void rotate(int[] nums, int k) {
		if(nums==null || nums.length<2) return;
		
		int len = nums.length;
		k = k % len;
		if(k==0) return;
		
		int[] temp = Arrays.copyOf(nums, len);
		for (int i = 0; i < len; i++) {
			nums[i] = temp[(len-k+i)%len];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		int[] b = {5,6,7,1,2,3,4};
		(new V3()).rotate(a, 3);
		System.out.println(Arrays.toString(a));
	}
}
