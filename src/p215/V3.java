package p215;

import java.util.Random;

public class V3 {
	
	/**
	 * quick select add random
	 */
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length-1, --k);
	}

	private int quickSelect(int[] nums, int i, int j, int k) {
		Random random = new Random();
		int i1 = random.nextInt(j-i+1);
		int t = nums[i1+i];
		nums[i1+i] = nums[i];
		
		int l=i, r=j;
		while(l<r){
			while(l<r && nums[r]<=t)
				r--;
			nums[l] = nums[r];
			while(l<r && nums[l]>=t)
				l++;
			nums[r] = nums[l];
		}
		if(l == k){
			return t;
		}else if(l<k){
			return quickSelect(nums, l+1, j, k);
		}
		return quickSelect(nums, i, l-1, k);
	}
	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		V3 v = new V3();
		System.out.println(v.findKthLargest(arr, 2));
	}
}
