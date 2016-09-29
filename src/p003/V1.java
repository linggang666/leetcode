package p003;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class V1 {
	
	/**
	 * hash ＋　strting
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
			return s.length();
		}
        
		String resultStr = s.substring(0, 1);
		Map<String, String> m = new HashMap<String, String>();
		
		int len = s.length();
		for (int i = 0; i < len; i++) {
			String c = s.substring(i, i+1);
			
			Iterator<Entry<String, String>> iter = m.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry<String, String> entry = iter.next();
				String tmp = entry.getValue();
				if(tmp.indexOf(c) != -1){
					iter.remove();
				}else{
					tmp = tmp + c;
					if(tmp.length()> resultStr.length()){
						resultStr = tmp;
					}
					entry.setValue(tmp);
				}
			}
			m.put(c, c);
		}
		
		return resultStr.length();
    }
}
