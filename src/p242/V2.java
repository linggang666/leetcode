package p242;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class V2 {
	public boolean isAnagram(String s, String t) {
		if(s == t){
			return true;
		}
		if(s == null || t==null || s.length()!=t.length()){
			return false;
		}
		
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			if(m.get(sc) == null){
				m.put(sc, 1);
			}else{
				m.put(sc, m.get(sc)+1);
			}
			
			char tc = t.charAt(i);
			if(m.get(tc) == null){
				m.put(tc, -1);
			}else{
				m.put(tc, m.get(tc)-1);
			}
		}
		
		for(Map.Entry<Character, Integer> e : m.entrySet()){
			if(e.getValue() != 0){
				return false;
			}
		}
		
		return true;
	}
}
