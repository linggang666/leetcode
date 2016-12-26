package p127;

import java.util.HashSet;
import java.util.Set;

public class V2 {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<>();
		Set<String> endSet = new HashSet<>();
		beginSet.add(beginWord);
		endSet.add(endWord);
		
		int res = 1;
		while(!beginSet.isEmpty() && !endSet.isEmpty()){
			if(beginSet.size()>endSet.size()){
				Set<String> s = beginSet;
				beginSet = endSet;
				endSet = s;
			}
			Set<String> toSet = new HashSet<>();
			for(String word: beginSet){
				for (int i = 0; i < word.length(); i++) {
					char[] fromArr = word.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						fromArr[i] = c;
						String temp = String.valueOf(fromArr);
						if(endSet.contains(temp)){
							return res+1;
						}
						if(wordList.contains(temp)){
							toSet.add(temp);
							wordList.remove(temp);
						}
					}
				}
			}
			beginSet = toSet;
			res++;
		}
	    return 0;
	}
	
	public static void main(String[] args) {
		V2 v = new V2();
		
		Set<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		int res = v.ladderLength("hit", "cog", set);
		System.out.println(res);
	}
}
