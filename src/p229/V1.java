package p229;

import java.util.List;

public class V1 {
	
	public List<Integer> majorityElement(int[] nums) {
        
		int n1=0,n2=0;
		int c1=0,c2=0;
		
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == n1){
				c1++;
			}else if(nums[i] == n2){
				c2++;
			}else if(c1==0){
				n1 = nums[i];
				c1++;
			}else if(c2 == 0){
				n2 = nums[i];
				c2++;
			}else{
				c1--;
				c2--;
			}
		}
		
		return null;
    }
}
