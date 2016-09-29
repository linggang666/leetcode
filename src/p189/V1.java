package p189;

import java.util.Arrays;

public class V1 {
	public void rotate(int[] nums, int k) {
		if(nums==null || nums.length<2) return;
		
		int len = nums.length;
		k = k % len;
		if(k==0) return;
		
		int[] temp = Arrays.copyOf(nums, len);
		for (int i = 0; i < len; i++) {
			nums[(i+k)%len] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7};
		(new V1()).rotate(a, 6);
		System.out.println(Arrays.toString(a));
	}
}
