package p038;

public class V1 {
	public String countAndSay(int n) {
		if(n == 1) return "1";
		
		String preString = countAndSay(n-1);
		char c = preString.charAt(0);
		int count = 1, strLen = preString.length();
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < strLen; i++) {
			if(c != preString.charAt(i)){
				sb.append(count).append(c);
				c = preString.charAt(i);
				count = 1;
			}else{
				count++;
			}
		}
		sb.append(count).append(c);
		
		return sb.toString();
	}
}
