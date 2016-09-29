package p242;

import java.util.Arrays;

public class V1 {
	public boolean isAnagram(String s, String t) {
		if(s == t){
			return true;
		}
		if(s == null || t==null || s.length()!=t.length()){
			return false;
		}
		
		char[] c1 = s.toCharArray();
		char[] c2 = t.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		
		return Arrays.toString(c1).equals(Arrays.toString(c2));
	}
}
