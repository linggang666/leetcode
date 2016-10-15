package p316;

public class V1 {

	public String removeDuplicateLetters(String s) {
		if(s==null || s.length()<1) return s;
		
		int[] cnt = new int[26];
		char[] chars = s.toCharArray();
		for (char c : chars) {
			cnt[c-'a']++;
		}
		int minPos = 0;
		for (int i = 0; i < chars.length; i++) {
			if(chars[i] < chars[minPos]) minPos = i;
			if(--cnt[chars[i]-'a']==0) break;
		}
		return chars[minPos] + removeDuplicateLetters(s.substring(minPos+1).replaceAll(chars[minPos]+"", ""));
	}
	
	public static void main(String[] args) {
		V1 v1 = new V1();
		System.out.println(v1.removeDuplicateLetters("ebdcabc"));//ebdac
		System.out.println(v1.removeDuplicateLetters("bcabc"));//abc
	}
}
