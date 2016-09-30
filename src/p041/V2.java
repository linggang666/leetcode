package p041;

import java.util.Arrays;
import java.util.BitSet;

public class V2 {
	
	
	public int firstMissingPositive(int[] nums) {
		BitSet set = new BitSet();
		for(int i = 0; i < nums.length; i++){
			if(nums[i] >= 0){
				set.set(nums[i]);
			}
		}
		return set.nextClearBit(1);
	}

	public static void main(String[] args) {
		int[] a = {-2,1,3,5,2};
		V2 v = new V2();
		
		System.out.println(v.firstMissingPositive(a));
		System.out.println(Arrays.toString(a));
	}

}
