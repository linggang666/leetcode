package p139;

import java.util.HashSet;
import java.util.Set;

public class V1 {
	
	/**
	 * 超时
	 * @param s
	 * @param wordDict
	 * @return
	 */
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s == null || s.length()==0) return true;
		
		for (int i = 1; i <= s.length(); i++) {
			String subStr = s.substring(0, i);
			if(wordDict.contains(subStr) && wordBreak(s.substring(i), wordDict)){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		Set<String> s = new HashSet<>();
		s.add("leet");
		s.add("code");
		System.out.println(v.wordBreak("leetcode", s));
	}
}
