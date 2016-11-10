package p215;

import java.util.Random;

public class V4 {
	
	/**
	 * quick select add random
	 */
	public int findKthLargest(int[] nums, int k) {
		int i=0,j=nums.length-1, res=0;
		Random random = new Random();
		k--;
		
		while(i<=j){
			int i1 = random.nextInt(j-i+1);
			res = nums[i1+i];
			nums[i1+i] = nums[i];
			
			int l=i, r=j;
			while(l<r){
				while(l<r && nums[r]<=res) r--;
				nums[l] = nums[r];
				while(l<r && nums[l]>=res) l++;
				nums[r] = nums[l];
			}
			
			if(l == k) break;
			if(l<k) i=l+1;
			else j=l-1;
		}
		return res;
	}

	
	public static void main(String[] args) {
		int[] arr = {3,2,1,5,6,4};
		V4 v = new V4();
		System.out.println(v.findKthLargest(arr, 1));
	}
}
