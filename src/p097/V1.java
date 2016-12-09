package p097;

public class V1 {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if(len1+len2!=len3){
			return false;
		}
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();
		
		boolean[][] dp = new boolean[len1+1][len2+1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if(i==0 && j==0){
					dp[0][0] = true;
				}else if(i==0){
					dp[0][j] = dp[0][j-1] && c2[j-1]==c3[j-1];
				}else if(j==0){
					dp[i][0] = dp[i-1][0] && c1[i-1]==c3[i-1];
				}else{
					dp[i][j] = dp[i-1][j] && c1[i-1]==c3[i+j-1] || dp[i][j-1] && c2[j-1]==c3[i+j-1];
				}
			}
		}
		
		return dp[len1][len2];
    }
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
}
