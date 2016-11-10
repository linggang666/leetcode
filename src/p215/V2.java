package p215;

public class V2 {
	
	/**
	 * quick select
	 */
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length-1, --k);
	}

	private int quickSelect(int[] nums, int i, int j, int k) {
		int l=i, r=j, t = nums[i];
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
		V2 v = new V2();
		System.out.println(v.findKthLargest(arr, 3));
	}
}
