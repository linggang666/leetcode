package p646;

import java.util.Arrays;
import java.util.Comparator;

public class V1 {
    
    /**
     * dp
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        
        int len = pairs.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        int[][] arr = {
                {6,7},
                {1,2},
                {2,3},
                {3,4},
                {2,4}
        };
        
        V1 v = new V1();
        System.out.println(v.findLongestChain(arr));
    }
}
