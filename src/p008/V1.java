package p008;

public class V1 {
	public int myAtoi(String str) {
		str = str.trim();
		if(str.length() == 0){
			return 0;
		}
		
		boolean isN = false;
		long result = 0l;
		if(str.charAt(0) == '-'){
			isN = true;
			str = str.substring(1);
		}else if(str.charAt(0) == '+'){
			str = str.substring(1);
		}
		
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			
			if(c >= '0' && c<='9'){
				if(result != 0 || c != '0'){
					result = result * 10 + c - 48;
				}else{
					continue;
				}
			}else{
				break;
			}
			
			if(isN && -result < Integer.MIN_VALUE){
				return Integer.MIN_VALUE;
			}else if(!isN && result>Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}
		}
		
		result = isN ? -result : result;
        return (int) result;
    }
}
