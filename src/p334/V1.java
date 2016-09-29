package p334;

public class V1 {
	public boolean increasingTriplet(int[] nums) {
		if(nums.length < 3) return false;
		int  first=nums[0], scond = nums[0]; 
		for (int i = 1; i < nums.length; i++) {
			if(first == scond){
				if(nums[i] < first){
					first = nums[i];
				}
				scond = nums[i];
			}else if(nums[i] > scond){
				return true;
			}else if(nums[i] > first){
				scond = nums[i];
			}else{
				first = nums[i];
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] a = {7, 8, 4, 3, 5,5};
		V1 v = new V1();
		System.out.println(v.increasingTriplet(a));
	}
}
