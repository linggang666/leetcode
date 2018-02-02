package p044;

import java.util.Arrays;

public class Solution {
    
    /**
     * dp
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        
        if(pLen == 0) {
            return sLen == 0;
        }
        if(sLen == 0) {
            for (char c:pArr) {
                if(c!='*') return false;
            }
            return true;
        }
        
        boolean[][] dp = new boolean[pLen+1][sLen+1];
        dp[0][0] = true;
        for (int i = 1; i <= sLen && pArr[0]=='*'; i++) {
            dp[0][i] = true; 
        }
        for (int i = 1; i <= pLen; i++) {
            dp[i][0] = dp[i-1][0] && pArr[i-1]=='*';
        }

        for (int i = 1; i <= pLen; i++) {
            for (int j = 1; j <= sLen; j++) {
                if(pArr[i-1]=='*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j-1] && (pArr[i-1]=='?' || pArr[i-1]==sArr[j-1]);
                }
            }
        }
        return dp[pLen][sLen];
    }
    
    public void p(boolean[][] a) {
        System.out.println();
        for (boolean[] bs : a) {
            System.out.println(Arrays.toString(bs));
        }
    }
    
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.isMatch("adacsdfsdfc", "a*d*c"));
        System.out.println(s.isMatch("a", "aa"));
        System.out.println(s.isMatch("aa", "aa"));
    }

}
