package p344;

public class V1 {
	public String reverseString(String s) {
		if(s == null || s.length() < 2){
			return s;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = s.length()-1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
