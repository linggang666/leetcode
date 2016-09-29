package p260;

import java.util.Arrays;

public class V1 {
	public int[] singleNumber(int[] nums) {
        
		int bit = 0;
		for (int i : nums) {
			bit ^= i;
		}
		
		int bitPos = 0;
		while((bit>>bitPos & 1) == 0){
			bitPos++;
		}
		
		int bit1=0, bit2=0;
		for (int i : nums) {
			if((i>>bitPos & 1) == 0){
				bit1 ^= i;
			}else{
				bit2 ^= i;
			}
		}
		
		return new int[]{bit1,bit2};
    }
	
	public static void main(String[] args) {
		int[] a = {1,2,0,2,1,4};
		System.out.println(Arrays.toString((new V1()).singleNumber(a)));
	}
}
