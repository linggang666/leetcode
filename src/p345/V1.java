package p345;

public class V1 {
	public String reverseVowels(String s) {
		if(s == null || s.length() <=1){
			return s;
		}
		
		int l=0, r=s.length()-1;
		char[] sArr = s.toCharArray();
		while(l < r){
			if(isVowel(sArr[l]) && isVowel(sArr[r])){
				char t = sArr[l];
				sArr[l] = sArr[r];
				sArr[r] = t;
				l++;
				r--;
			}
			if(!isVowel(sArr[l])) l++; 
			if(!isVowel(sArr[r])) r--; 
		}
		return new String(sArr);
	}
	
	private boolean isVowel(char c){
		c = Character.toLowerCase(c);
		if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u'){
			return true;
		}
		return false;
	}
}
