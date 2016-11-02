package p030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2 {
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if(words.length==0 || s.length()==0) return res;
		
		Map<String, Integer> wordMap = new HashMap<>();
		for (String word: words) {
			if(wordMap.containsKey(word)){
				wordMap.put(word, wordMap.get(word)+1);
			}else{
				wordMap.put(word, 1);
			}
		}
		int wordLen = words[0].length();
		for (int i = 0; i < wordLen; i++) {
			Map<String, Integer> curMap = new HashMap<>();
			int curCnt = 0;
			int start = i;
			for (int j = i; j <= s.length()-wordLen; j+=wordLen) {
				String subStr = s.substring(j, j+wordLen);
				if(wordMap.containsKey(subStr)){
					if(curMap.containsKey(subStr)){
						curMap.put(subStr, curMap.get(subStr)+1);
					}else{
						curMap.put(subStr, 1);
					}
					
					curCnt++;
					while(curMap.get(subStr)>wordMap.get(subStr)){
						String temp = s.substring(start,start+wordLen);
						curMap.put(temp, curMap.get(temp)-1);
						start += wordLen;
						curCnt--;
					}
					
					if(curCnt == words.length){
						res.add(start);
						String temp = s.substring(start, start+wordLen);
						curMap.put(temp, curMap.get(temp)-1);
						start += wordLen;
						curCnt--;
					}
				}else{
					curCnt=0;
					curMap.clear();
					start = j+wordLen;
				}
			}
		}
        return res;
    }

	public static void main(String[] args) {
		V2 v = new V2();
		String[] words = {"bar","foo","the"};
		System.out.println(Arrays.toString(v.findSubstring("barfoofoobarthefoobarman", words).toArray()));
	}
}
