package p041;

import java.util.Arrays;
import java.util.BitSet;

public class V1 {
	
	
	public int firstMissingPositive(int[] nums) {
		int len = nums.length, i=0;	
		while(i < len){
			if(nums[i]>0 && nums[i] < len && nums[i]!=i+1 && nums[nums[i]-1] != nums[i]){
				int t=nums[i];
				nums[i] = nums[t-1];
				nums[t-1] = t;
			}else{
				i++;
			}
		}
		i=0;
		while(i<len){
			if(nums[i] != i+1)
				return i+1;
			i++;
		}
		return len+1;
	}
	
	public static void main(String[] args) {
		int[] a = {-2,1,1,2};
		V1 v = new V1();
		
		System.out.println(v.firstMissingPositive(a));
		System.out.println(Arrays.toString(a));
	}

}
