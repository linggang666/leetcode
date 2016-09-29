package p169;

import java.util.HashMap;
import java.util.Map;

public class V2 {
	public int majorityElement(int[] nums) {
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		for (int i : nums) {
			if(m.get(i) == null){
				m.put(i, 1);
			}else{
				m.put(i, m.get(i)+1);
			}
			
			if(m.get(i) > nums.length /2){
				return i;
			}
		}
		return 0;
	}
}
