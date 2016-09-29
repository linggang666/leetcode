package p344;

public class V2 {
	public String reverseString(String s) {
		if(s == null || s.length() < 2){
			return s;
		}
		
		char[] cArr = s.toCharArray();
		int l=0, r=s.length()-1;
		while (l<r) {
			char c = cArr[l];
			cArr[l] = cArr[r];
			cArr[r] = c;
			l++;
			r--;
		}
		return new String(cArr);
	}
}
