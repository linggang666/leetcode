package p219;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if(nums == null || nums.length<2) return false;
		
		Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(mapping.containsKey(nums[i]) && i-mapping.get(nums[i]) <= k){
				return true;
			}
			mapping.put(nums[i], i);
		}
		
        return false;
    }
}
