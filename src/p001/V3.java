package p001;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class V3 {
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		int len = nums.length;
		for(int i=0; i<len; i++){
			m.put(nums[i], i);
		}
		int temp;
		for(int i=0; i<len; i++){
			temp = target - nums[i];
			if(m.containsKey(temp) && m.get(temp) != i){
				return new int[]{i, m.get(temp)};
			}
		}
		return null;
	}
}
