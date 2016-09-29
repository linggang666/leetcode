package p217;

import java.util.HashSet;
import java.util.Set;

public class V2 {
	public boolean containsDuplicate(int[] nums) {
		if(nums == null || nums.length < 2){
			return false;
		}
		
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(s.contains(nums[i])){
				return true;
			}
			s.add(nums[i]);
		}
        return false;
    }
}
