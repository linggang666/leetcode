package p459;

public class V1 {
	public boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		char[] strArr = str.toCharArray();
		for(int step=len/2; step>0; step--){
			if(len%step>0){
				continue;
			}
			boolean isRepeate = true;
			for (int i = 0; i < step && isRepeate; i++) {
				for (int j = step+i; j < len && isRepeate; j+=step) {
					if(strArr[i] != strArr[j]) 
						isRepeate = false;
				}
			}
			if(isRepeate) 
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.repeatedSubstringPattern("abab"));
	}
}
