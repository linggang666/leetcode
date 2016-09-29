package p066;

public class V1 {
	public int[] plusOne(int[] digits) {
		if(digits == null){
			return new int[0];
		}
		
		int v = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = digits.length-1; i >=0 ; i--) {
			v += digits[i];
			sb.insert(0,v%10);
			v /= 10;
		}
		while(v!=0){
			sb.insert(0,v%10);
			v /= 10;
		}
		
		int[] result = new int[sb.length()];
		for (int i = 0; i < sb.length(); i++) {
			result[i] = sb.charAt(i) - '0';
		}
		
		return result;
	}
}
