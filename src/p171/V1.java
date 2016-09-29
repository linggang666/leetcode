package p171;

public class V1 {
	public int titleToNumber(String s) {
		if(s == null){
			return 0;
		}
		
		int result = 0;
		int len = s.length();
		for (int i = len-1; i >= 0; i--) {
			char c = s.charAt(i);
			result += Math.pow(26, len-i-1) * (c - 'A' + 1);
		}

		return result;
	}
}
