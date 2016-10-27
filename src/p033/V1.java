package p033;

public class V1 {
	public int search(int[] nums, int target) {
        
		return _search(nums, 0, nums.length-1, target);
    }

	private int _search(int[] nums, int l, int r, int target) {
		if(l>=r && nums[l]!=target) return -1;
		
		int mid = l + (r-l)/2;
		if(nums[mid] == target) return mid;
		if(nums[mid+1]<=nums[r]){
			if(target >= nums[mid+1] && target <= nums[r]){
				return _search(nums, mid+1, r, target);
			}else{
				return _search(nums, l, mid-1, target);
			}
		}else{
			if(target >= nums[l] && target <= nums[mid-1]){
				return _search(nums, l, mid-1, target);
			}else{
				return _search(nums, mid+1, r, target);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {6,1};
		V1 v = new V1();
		System.out.println(v.search(a, 61));
	}
}
