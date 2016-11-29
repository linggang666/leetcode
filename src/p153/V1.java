package p153;

public class V1 {
	
	public int findMin(int[] nums) {
        return _findMin(nums, 0, nums.length-1);
    }

	private int _findMin(int[] nums, int l, int r) {
		if(l==r || nums[l]<nums[r]) 
			return nums[l];
		
		int m = l+(r-l)/2;
		if(nums[l]<nums[m])
			return _findMin(nums, m+1, r);
		return _findMin(nums, l+1, m);
	}
	
	
	public static void main(String[] args) {
		int[] a ={4,5,6,7,0,1,2};
		V1 v = new V1();
		System.out.println(v.findMin(a));
	}
}
