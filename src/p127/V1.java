package p127;

import java.util.HashSet;
import java.util.Set;

public class V1 {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> fromSet = new HashSet<>();
		fromSet.add(beginWord);
		wordList.add(endWord);
		int res = 1;
		while(!fromSet.contains(endWord)){
			Set<String> toSet = new HashSet<>();
			for(String str : fromSet){
				for (int i = 0; i < str.length(); i++) {
					char[] strArr = str.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						strArr[i] = c;
						String temp = String.valueOf(strArr);
						if(wordList.contains(temp)){
							toSet.add(temp);
							wordList.remove(temp);
						}
					}
				}
			}
			fromSet = toSet;
			if(toSet.isEmpty()) return 0;
			res++;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		V1 v = new V1();

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
