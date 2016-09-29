package p392;

public class V1 {

	public boolean isSubsequence(String s, String t) {
		
		int sLen = s.length(), tLen=t.length();
		int si=0,ti=0;
		while(si<sLen && ti<tLen){
			if(s.charAt(si) == t.charAt(ti)){
				si++;
			}
			ti++;
		}
		
		if(si == sLen) 
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		
		System.out.println((new V1()).isSubsequence("asd", "adsd"));
	}

}
