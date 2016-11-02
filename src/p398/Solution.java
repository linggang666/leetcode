package p398;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {
	
	private Map<Integer,List<Integer>> map;
	private Random r ;
	public Solution(int[] nums) {
		r = new Random();
        map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
			List<Integer> list = map.get(nums[i]);
			if(list == null){
				list = new ArrayList<Integer>();
				map.put(nums[i], list);
			}
			list.add(i);
		}
    }
    
    public int pick(int target) {
    	List<Integer> list = map.get(target);
        return list.get(r.nextInt(list.size()));
    }
}
