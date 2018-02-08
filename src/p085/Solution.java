package p085;

import java.util.Arrays;

public class Solution {
    
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if(matrix.length==0 || matrix[0].length==0) {
            return res;
        }
        int rows = matrix.length, cols = matrix[0].length;
        
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < cols; i++) {
            dp[0][i] = matrix[0][i]=='1'?1:0;
        }
        for (int i = 0; i < cols; i++) {
            for (int j = 1; j < rows; j++) {
                if(matrix[j][i] == '1') {
                    dp[j][i] = dp[j-1][i]+1;
                }
            }
        }
        
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                int t = j-1;
                while(t>=0 && dp[i][t]>dp[i][j]) {
                    res = Math.max(res, dp[i][t]*(j-t));
                    dp[i][t] = dp[i][j];
                    t--;
                }
            }
            for (int k = cols-1; k >= 0; k--) {
                res = Math.max(res, dp[i][k]*(cols-k));
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        
        Solution s = new Solution();
        System.out.println(s.maximalRectangle(matrix));
        /*
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
         */
    }
}
