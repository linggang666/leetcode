package p139;

import java.util.HashSet;
import java.util.Set;

public class V2 {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length()+1];
		dp[0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = i-1; j >=0; j--) {
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}
	
	public static void main(String[] args) {
		V2 v = new V2();
		Set<String> s = new HashSet<>();
		s.add("leet");
		s.add("code");
		System.out.println(v.wordBreak("leetcode", s));
	}
}
