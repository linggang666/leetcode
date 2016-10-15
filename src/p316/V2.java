package p316;

public class V2 {

	public String removeDuplicateLetters(String s) {
		if(s==null || s.length()<1) return s;
		
		int[] cnt = new int[26];
		boolean[] visited = new boolean[26];
		char[] chars = s.toCharArray();
		for (char c : chars) {
			cnt[c-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			cnt[c-'a']--;
			if(visited[c-'a']) continue;
			while(sb.length()>0 && sb.charAt(sb.length()-1)>c && cnt[sb.charAt(sb.length()-1)-'a']>0){
				visited[sb.charAt(sb.length()-1)-'a'] = false;
				sb.deleteCharAt(sb.length()-1);
			}
			sb.append(c);
			visited[c-'a'] = true;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		V2 v1 = new V2();
		System.out.println(v1.removeDuplicateLetters("ebdcabc"));//ebdac
		System.out.println(v1.removeDuplicateLetters("bcabc"));//abc
	}
}
