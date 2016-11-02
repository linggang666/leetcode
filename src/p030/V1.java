package p030;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V1 {
	
	/**
	 * Time Limit Exceeded
	 * @return
	 */
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
		int wordsLen = words[0].length() * words.length;
		for (int i = 0; i <= s.length()-wordsLen; i++) {
			if(isValid(s.substring(i, i+wordsLen),new HashMap<>(wordMap),wordLen)){
				res.add(i);
			}
		}
        return res;
    }

	private boolean isValid(String str, Map<String, Integer> wordCnt, int wordLen) {
		for (int i = 0; i < str.length(); i+=wordLen) {
			String subStr = str.substring(i,i+wordLen);
			if(!wordCnt.containsKey(subStr)||wordCnt.get(subStr)==0){
				return false;
			}
			wordCnt.put(subStr, wordCnt.get(subStr)-1);
		}
		return true;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		String[] words = {"foo", "bar"};
		System.out.println(Arrays.toString(v.findSubstring("barfoothefoobarman", words).toArray()));
		System.out.println(Arrays.toString(v.findSubstring("bafoothefoobarman", words).toArray()));
	}
}
