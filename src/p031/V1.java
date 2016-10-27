package p031;

import java.util.Arrays;

public class V1 {
	
	/**
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {
		int pos = -1;
		for (int i = nums.length-1; i > 0; i--) {
			if(nums[i]>nums[i-1]){
				pos = i-1;
				int pos2 = nums.length;
				while(nums[--pos2]<=nums[pos]);
				swap(nums, pos, pos2);
				break;
			}
		}
		int l = pos==-1?0:pos+1;
		int r = nums.length-1;
		while(l<r){
			swap(nums, l++, r--);
		}
	}

	private void swap(int[] nums, int l, int r) {
		int t = nums[l];
		nums[l] = nums[r];
		nums[r] = t;
	}
	
	
	public static void main(String[] args) {
		V1 v = new V1();
//		int[] a = {2,3,1,3,3};
//		v.nextPermutation(a);
//		System.out.println(Arrays.toString(a));
		//[1,2,3,4,2,3,8,4,6]
//		int[] b = {1,2,3,4,2,3,6,8,7,4};
		int[] b = {1,5,1};
		v.nextPermutation(b);
		System.out.println(Arrays.toString(b));
	}
}
