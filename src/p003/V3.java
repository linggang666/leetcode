package p003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class V3 {
	
	/**
	 * 按逻辑走，不能轻易觉得hash好使
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2){
			return s.length();
		}
        int maxLen = 0;
        int startIndex = 0,endIndex = 1;
        
		int len = s.length();
		for (int i = 1; i < len; i++) {
			String str = s.substring(startIndex, endIndex);
			int pos = str.indexOf(s.charAt(i));
			if(pos != -1){
				if(endIndex-startIndex > maxLen){
					maxLen = endIndex-startIndex;
				}
				startIndex = startIndex + pos + 1;
			}
			endIndex++ ;
		}
		if(endIndex-startIndex > maxLen){
			maxLen = endIndex-startIndex;
		}
		
		return maxLen;
    }
}
