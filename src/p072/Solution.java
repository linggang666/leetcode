package p072;

import java.util.Arrays;

public class Solution {

    public int minDistance(String word1, String word2) {
        int len1=word1.length(), len2=word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minDistance("zoologicoarchaeologist", "zoogeologist"));
        //zoogeologist
        //zoogeologist
    }

}
