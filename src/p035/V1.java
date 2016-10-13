package p035;

public class V1 {
	
	public int searchInsert(int[] nums, int target) {
		return _searchInsert(nums,0, nums.length-1, target);
	}

	private int _searchInsert(int[] nums, int l, int r, int target) {
		if(l>r) return l;
		
		int mid = l + (r-l)/2;
		if(nums[mid] == target) return mid;
		if(nums[mid] > target) return _searchInsert(nums, l, mid-1, target);
		return _searchInsert(nums, mid+1, r, target);
	}
}
