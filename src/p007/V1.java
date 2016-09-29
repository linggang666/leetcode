package p007;

public class V1 {
	public int reverse(int x) {
		StringBuffer sb = new StringBuffer();
		String s = String.valueOf(x);
		int len = s.length();
		boolean isN = false;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c == '-'){
				isN = true;
				continue;
			}
			sb.insert(0, c);
		}
		if(isN){
			sb.insert(0, '-');
			if(sb.length() < String.valueOf(Integer.MIN_VALUE).length() || sb.toString().compareTo(String.valueOf(Integer.MIN_VALUE)) <= 0){
				return Integer.parseInt(sb.toString());
			}
		}else{
			if(sb.length() < String.valueOf(Integer.MAX_VALUE).length() || sb.toString().compareTo(String.valueOf(Integer.MAX_VALUE)) <= 0){
				return Integer.parseInt(sb.toString());
			}
		}
		return 0;
	}
}
