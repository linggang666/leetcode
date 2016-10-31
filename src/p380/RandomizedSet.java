package p380;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	private Map<Integer, Integer> map;
	private List<Integer>  list;
	Random random ;
	
	/** 
	 * Initialize your data structure here. 
	 */
    public RandomizedSet() {
    	map = new HashMap<Integer, Integer>();
    	list = new ArrayList<Integer>();
    	random = new Random();
    }
    
    /** 
     * Inserts a value to the set. Returns true if the set did not 
     * already contain the specified element. 
     */
    public boolean insert(int val) {
        if(map.containsKey(val)){
        	return false;
        }
        map.put(val, list.size());
        list.add(val);
    	return true;
    }
    
    /** 
     * Removes a value from the set. 
     * Returns true if the set contained the specified element. 
     */
    public boolean remove(int val) {
    	if(!map.containsKey(val)){
    		return false;
    	}
    	list.set(map.get(val), list.get(list.size()-1));
    	map.put(list.get(list.size()-1), map.get(val));
    	list.remove(list.size()-1);
    	map.remove(val);
        return true;
    }
    
    /** 
     * Get a random element from the set. 
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
