package p389;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	public char findTheDifference(String s, String t) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(m.containsKey(c)){
				m.put(c, m.get(c)+1);
			}else{
				m.put(c, 1);
			}
		}
		
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if(!m.containsKey(c)){
				return c;
			}
			int count = m.get(c);
			if(count == 1){
				m.remove(c);
			}else{
				m.put(c, --count);
			}
		}
		
		return ' ';
	}
}
