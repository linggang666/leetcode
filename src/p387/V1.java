package p387;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class V1 {
	public int firstUniqChar(String s) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		Set<Character> set = new HashSet<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(set.contains(c)){
				m.remove(c);
			}else{
				set.add(c);
				m.put(c, i);
			}
		}
		
		if(m.isEmpty()){
			return -1;
		}
		
		int min = Integer.MAX_VALUE;
		for(Map.Entry<Character, Integer> e : m.entrySet()){
			min = Math.min(min, e.getValue());
		}
		return min;
	}
}
