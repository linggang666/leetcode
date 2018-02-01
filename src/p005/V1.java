package p005;

public class V1 {
	
	/**
	 * manacher算法
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		
		int len1 = s.length()*2+1;
		char[] arr = new char[len1];
		int[] lenArr = new int[len1];
		
		arr[0] = '*';
		lenArr[0] = 1;
		for (int i = 0; i < s.length(); i++) {
            arr[2*i+1] = s.charAt(i);
            arr[2*i+2] = '*';
        }
		
		int maxRight=0, midPos=0, maxPos=0;
		for (int i = 1; i < len1; i++) {
            if(i<midPos) {
                lenArr[i] = Math.min(lenArr[2*midPos-i], maxRight-i+1);
            }else {
                lenArr[i] = 1;
            }
            
            while(i>=lenArr[i] && i+lenArr[i]<len1 && arr[i-lenArr[i]]==arr[i+lenArr[i]]) {
                lenArr[i]++;
                if(i+lenArr[i]<len1 && arr[i+lenArr[i]]>maxRight) {
                    maxRight = arr[i+lenArr[i]];
                    midPos = i;
                }
            }
            if(lenArr[i]>lenArr[maxPos]) maxPos = i;
        }
		
		StringBuilder res = new StringBuilder();
		for (int i = maxPos-lenArr[maxPos]+1; i < maxPos+lenArr[maxPos]; i++) {
            if(arr[i]!='*') {
                res.append(arr[i]);
            }
        }
		
        return res.toString();
    }
	
	public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.longestPalindrome("sdffxfffddssdffddffds"));
    }
}
