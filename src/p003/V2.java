package p003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V2 {
	
	/**
	 * hash ＋　set
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
			return s.length();
		}
        
		int maxLen = 1;
		Map<Character, Set<Character>> m = new HashMap<Character, Set<Character>>();
		
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			
			Iterator<Entry<Character, Set<Character>>> iter = m.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<Character, Set<Character>> entry = iter.next();
				Set<Character> tmp = entry.getValue();
				if(tmp.contains(c)){
					iter.remove();
				}else{
					tmp.add(c);
					if(tmp.size() > maxLen){
						maxLen = tmp.size();
					}
					entry.setValue(tmp);
				}
			}
			Set<Character> tempSet = new HashSet<>();
			tempSet.add(c);
			m.put(c, tempSet);
		}
		
		return maxLen;
    }
}
