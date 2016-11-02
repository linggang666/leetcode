package p398;

import java.util.Random;

public class Solution1 {
	
	private int[] nums;
	private Random r ;
	public Solution1(int[] nums) {
		r = new Random();
        this.nums = nums;
    }
    
	public int pick(int target) {
		int res = -1,cnt=0;;
		for (int i = 0; i < nums.length; i++) {
			if(target == nums[i]){
				if(r.nextInt(++cnt) == 0){
					res = i;
				}
			}
		}
        return res;
    }
}
