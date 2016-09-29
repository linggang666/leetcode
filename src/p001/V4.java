package p001;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class V4 {
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		int temp;
		int len = nums.length;
		for(int i=0; i<len; i++){
			temp = target - nums[i];
			if(m.containsKey(temp)){
				return new int[]{ m.get(temp),i};
			}
			m.put(nums[i], i);
		}
		return null;
	}
}
