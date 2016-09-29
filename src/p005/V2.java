package p005;

import java.util.ArrayList;
import java.util.List;

public class V2 {
	
	
	public String longestPalindrome(String s) {
		String result = "";
		StringBuffer resultSb = new StringBuffer();
		int li, roi, rei;
		
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			li = i;
			roi = i+1;
			rei = i;
			if (li>=0 && (roi<len && s.charAt(li)==s.charAt(roi))){
				li--;
			}else{
			}
		}
        return result;
    }
}
