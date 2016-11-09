package p065;

public class V2 {
	
	public boolean isNumber(String s) {
		s = s.trim();
		if(s.length() == 0) 
			return false;
		
		char[] arr = s.toCharArray();
		int len = arr.length;
		boolean allowE = true, allowFloat = true;;
		boolean isShowDigit = false;
		for (int i = 0; i < len; i++) {
			int c = Character.toLowerCase(arr[i]);
			if(Character.isDigit(c)){
				isShowDigit = true;
				continue;
			}
			if(c == '+' || c=='-'){
				if(i==0 || arr[i-1]=='e' && i+1!=len){
					continue;
				}
			}else if(c == 'e'){
				if(allowE && i!=len-1 && isShowDigit){
					allowE = false;
					allowFloat = false;
					continue;
				}
			}else if(c == '.' ){
				if(allowFloat && (isShowDigit || i!=len-1)){
					allowFloat = false;
					continue;
				}
			}
			return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		V2 v = new V2();
		System.err.println(v.isNumber(".e1"));
		System.err.println(v.isNumber("+.e"));
		System.err.println(v.isNumber(" 005047e+6"));
	}
}
