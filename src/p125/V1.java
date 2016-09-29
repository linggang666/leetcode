package p125;

public class V1 {
	public boolean isPalindrome(String s) {
		
		s = s.toLowerCase();
		int i=0, j=s.length()-1;
		while(i<j){
			char lc = s.charAt(i);
			if(!Character.isLetterOrDigit(lc)){
				i++;
				continue;
			}
			char rc = s.charAt(j);
			if(!Character.isLetterOrDigit(rc)){
				j--;
				continue;
			}
			if(lc != rc) return false;
			i++;
			j--;
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
//		System.out.println(Character.is('2'));
		System.out.println((new V1()).isPalindrome("0P"));
	}
}
