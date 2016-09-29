package p383;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	public boolean canConstruct(String ransomNote, String magazine) {

		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for (int i = 0; i < magazine.length(); i++) {
			char c = magazine.charAt(i);
			if(m.containsKey(c)){
				m.put(c, m.get(c) + 1);
			}else{
				m.put(c, 1);
			}
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			if(!m.containsKey(c) || m.get(c) == 0){
				return false;
			}
			m.put(c, m.get(c)-1);
		}
		return true;
	}
}
