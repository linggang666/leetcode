package p303;

public class NumArray {
	
	private int[] sumArr;
	public NumArray(int[] nums) {
		this.sumArr = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			this.sumArr[i+1] = this.sumArr[i] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		return  this.sumArr[j+1] - this.sumArr[i];
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,5,6,7,98,4};
		NumArray n = new NumArray(a);
		
		System.out.println(n.sumRange(0, 4));
	}
}
