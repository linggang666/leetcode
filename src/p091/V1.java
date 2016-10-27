package p091;

import java.util.Arrays;

public class V1 {
	
	public int numDecodings(String s) {
		if(s == null || s.length()==0) 
			return 0;
		
		char[] arr = s.toCharArray();
		int[] dp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			
			if(i == 0){
				if(arr[0] == '0'){
					return 0;
				}
		        dp[0] = 1;
		        continue;
			}
			
			dp[i] = dp[i-1];
			if(!Character.isDigit(arr[i])) 
				continue;
			
			if(Character.isDigit(arr[i-1])){
				int cur = Integer.valueOf(""+arr[i-1]+arr[i]);
				if(cur == 0 ) {
					return 0;
				}else if(arr[i]=='0'){
					if(arr[i-1]>'2'){
						return 0;
					}else if(i-2>=0){
						dp[i] = dp[i-2];
					}
				}else if(cur>10 && cur<=26){
					if(i>2)
						dp[i] += dp[i-2];
					else
						dp[i] += 1;
				}
			}else if(arr[i]=='0'){
				return 0;
			}
		}
		return dp[s.length()-1];
	}
	
	/**
	 * 
	 */
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.numDecodings("1210121"));
		System.out.println(v.numDecodings("121012"));
	}
}
