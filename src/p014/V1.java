package p014;

public class V1 {
	public String longestCommonPrefix(String[] strs) {
		
		int strsLens = strs.length;
		if(strsLens == 0){
			return "";
		}else if(strsLens == 1){
			return strs[0]; 
		}
		
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < strsLens; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		
		StringBuffer result = new StringBuffer();
p:		for (int i = 0; i < minLen; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strsLens; j++) {
				if(c != strs[j].charAt(i)){
					break p;
				}
			}
			result.append(c+"");
		}
        return result.toString();
    }
}
