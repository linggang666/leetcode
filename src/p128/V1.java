package p128;

import java.util.HashMap;
import java.util.Map;

import sun.util.logging.resources.logging;

public class V1 {
	public int longestConsecutive(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		
		Map<Integer, Integer> groups = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if(groups.containsKey(nums[i])){
				continue;
			}
			
			int groupId = nums[i];
			if(groups.containsKey(nums[i]-1)){
				groupId = groups.get(nums[i]-1);
			}
			if(groups.containsKey(nums[i]+1)){
				if(groupId == nums[i]){
					groupId = groups.get(nums[i]+1);
				}else{
					int t = nums[i]+1;
					while(groups.containsKey(t)){
						groups.put(t, groupId);
						t++;
					}
				}
			}
			groups.put(nums[i], groupId);
		}
		
		int longest = 1;
		Map<Integer, Integer> m = new HashMap<>();
		for(Integer i:groups.values()){
			if(m.containsKey(i)){
				m.put(i, m.get(i)+1);
				longest = Math.max(longest, m.get(i));
			}else{
				m.put(i, 1);
			}
		}
		
		return longest;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,0,-1};
		V1 v = new V1();
		System.out.println(v.longestConsecutive(arr));
	}
}
