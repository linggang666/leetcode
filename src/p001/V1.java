package p001;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	public int[] twoSum(int[] nums, int target) {
    	
    	int len = nums.length;
    	Map<Integer, Integer> l = new HashMap<Integer, Integer>();  //小于
    	Map<Integer, Integer> r = new HashMap<Integer, Integer>();  //等于
    	Map<Integer, Integer> e = new HashMap<Integer, Integer>(); //大于 
    	int helf = target/2;
    	boolean isD = target % 2 == 0;
    	for (int i = 0; i < len; i++) {
    		if(isD && nums[i] == helf){
    			e.put(i, nums[i]);
    		}else if(nums[i] < helf){
    			l.put(i, nums[i]);
    		}else{
    			r.put(i, nums[i]);
    		}
		}
    	
    	if(e.size() > 1){
    		int[] result = new int[2];
    		int ri = 0;
    		for (Integer key : e.keySet()) {
				result[ri++] = key;
				if(ri == 2){
					return result;
				}
			}
    	}
    	
    	for(Map.Entry<Integer, Integer> lEntry: l.entrySet()){
    		for(Map.Entry<Integer, Integer> rEntry: r.entrySet()){
    			if(lEntry.getValue() + rEntry.getValue() == target){
    				return new int[]{lEntry.getKey(),rEntry.getKey()};
    			}
    		}
    	}
    	
		return null;
    }
}
