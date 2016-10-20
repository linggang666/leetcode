package p214;

public class V1 {
	public String shortestPalindrome(String s) {

		char[] a = s.toCharArray();
		int pos = a.length-1;
		while(pos>0){
			if(isPalindrome(a, pos)){
				break;
			}
			pos--;
		}
		StringBuilder sb = new StringBuilder(s.substring(pos+1));
		sb.reverse();
		sb.append(s);
		return sb.toString();
		
	}

	private boolean isPalindrome(char[] a, int r) {
		int l=0;
		while(l<r){
			if(a[l++] != a[r--])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.shortestPalindrome("abcd"));
	}
}
