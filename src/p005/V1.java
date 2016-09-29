package p005;


public class V1 {
	
	/**
	 * 超时
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		String result = "";
		StringBuffer resultSb = new StringBuffer();
		
		StringBuffer sb = new StringBuffer(s);
		int lenSb = sb.length();
		while(lenSb >= 0){
			sb.insert(lenSb, '\0'+"");
			lenSb--;
		}
		
		//System.out.println(sb.toString());
		s = sb.toString();
		
		int bi = 1;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			resultSb = new StringBuffer(c+"");
			
			while(i-bi>=0 && i+bi<len && s.charAt(i-bi)==s.charAt(i+bi) ){
				resultSb.insert(0, s.charAt(i-bi)).append(s.charAt(i-bi));
				bi++;
			}
			if(result.length() < resultSb.length()){
				result = resultSb.toString();
			}
			bi = 1;
		}
		
		resultSb = new StringBuffer(result);
		lenSb = resultSb.length() - 1;
		while(lenSb >= 0){
			if(resultSb.charAt(lenSb) == '\0'){
				resultSb.deleteCharAt(lenSb);
			}
			lenSb--;
		}
		
        return resultSb.toString();
    }
	
	
	
//	public String longestPalindrome(String s) {
//		List<Character> stack = new ArrayList<Character>();
//		String result = "";
//		StringBuffer resultSb = new StringBuffer();
//		int bi = 2;
//		
//		int len = s.length();
//		for (int i = 0; i < len; i++) {
//			char c = s.charAt(i);
//			
//			if (stack.size() - bi >=0 && stack.get(stack.size()-bi) == c){
//				bi = bi + 2;
//				resultSb.insert(0, c).append(c);
//			}else{
//				bi = 2;
//				resultSb = new StringBuffer(c+"");
//			}
//			if(resultSb.length()>result.length()){
//				result = resultSb.toString();
//			}
//			stack.add(c);
//		}
//        return result;
//    }
}
