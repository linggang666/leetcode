package p010;

import java.util.Arrays;

public class V1 {

    /**
     * 动态规划
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        boolean[][] dp = new boolean[plen+1][slen+1];
        
        dp[0][0] = true;
        for (int i = 1; i<plen &&  pArr[i]=='*'; i+=2) {
            dp[i+1][0] = true;
        }
        
        for (int i = 1; i<=plen ; i++) {
            for (int j = 1; j <= slen; j++) {
                if(sArr[j-1] == pArr[i-1] || pArr[i-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                }else if(i>1 &&pArr[i-1] == '*') {
                    dp[i][j] = dp[i-2][j] || (dp[i][j-1] && (pArr[i-2]=='.' || sArr[j-1]==pArr[i-2]));
                }
            }
        }
        for(boolean a[] : dp) {
            System.out.println(Arrays.toString(a));
        }
        return dp[plen][slen];
    }
    
    public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.isMatch("aa", ".*"));
    }
}
