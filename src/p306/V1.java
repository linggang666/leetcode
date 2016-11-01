package p306;

import java.math.BigInteger;

public class V1 {
	
	public boolean isAdditiveNumber(String num) {
		int len = num.length();
		if(len < 3) 
			return false;
		
		for (int i = 1; i <= len/2; i++) {
			String left = num.substring(0, i);
			for (int j = i+1; Math.max(i, j-i)+j <= len; j++) {
				String right = num.substring(i, j);
				if(_isAdditiveNumber(left, right, num.substring(j))){
					return true;
				}
				if(num.charAt(i) == '0') 
					break;
			}
			if(num.charAt(0) == '0') 
				break;
		}
		return false;
	}

	private boolean _isAdditiveNumber(String leftStr, String rightStr, String numStr) {
		String sumStr = (new BigInteger(leftStr)).add(new BigInteger(rightStr)).toString();
		if(!numStr.startsWith(sumStr)){
			return false;
		}
		numStr = numStr.replaceFirst(sumStr, "");
		if(numStr.length()==0){
			return true;
		}
		return _isAdditiveNumber(rightStr, sumStr, numStr);
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.isAdditiveNumber("12012122436"));
		System.out.println(v.isAdditiveNumber("101"));
		System.out.println(v.isAdditiveNumber("011235"));
	}
}
