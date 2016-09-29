package p013;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	
	private static Map<Character, Integer> charMapping = new HashMap<Character, Integer>();
	static{
		charMapping.put('I', 1);
		charMapping.put('V', 5);
		charMapping.put('X', 10);
		charMapping.put('L', 50);
		charMapping.put('C', 100);
		charMapping.put('D', 500);
		charMapping.put('M', 1000);
	}
	public int romanToInt(String s) {
		
		int r1=0, r2=0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(i+1 < len && charMapping.get(c)<charMapping.get(s.charAt(i+1))){
				r2 += charMapping.get(c);
			}else{
				r1 += charMapping.get(c);
			}
		}
		
        return r1-r2;
    }
	
}