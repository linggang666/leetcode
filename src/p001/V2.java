package p001;

import java.util.HashMap;
import java.util.Map;

public class V2 {
	
	public int[] twoSum(int[] nums, int target) {
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		Map<String, Integer> s = new HashMap<String, Integer>();
		int len = nums.length;
		for(int i=0; i<len; i++){

			if(!m.containsKey(nums[i])){
				m.put(nums[i], i);
			}else if(!s.containsKey(this.getSlaveKey(nums[i]))){
				s.put(this.getSlaveKey(nums[i]), i);
			}
		}
		int temp;
		for (Map.Entry<Integer, Integer> entry: m.entrySet()) {
			temp = target - entry.getKey();
			if(temp == entry.getKey() && s.containsKey(this.getSlaveKey(temp))){
				return new int[]{entry.getValue(), s.get(this.getSlaveKey(temp))};
			}else if(m.containsKey(temp)){
				return new int[]{entry.getValue(), m.get(temp)};
			}
		}
		
		return null;
	}
	
	private String getSlaveKey(int key){
		return "s"+key;
	}
}
