package p059;

import java.util.Arrays;

public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n<1)
            return res;
        
        int seq=1, top=0, bottom=n-1, left=0, right=n-1;
        while(top<=bottom && left<=right) {
            for (int i = 0; left+i<=right; i++) {
                res[top][left+i] = seq++;
            }
            top++;
            for (int i = 0; top+i<=bottom; i++) {
                res[top+i][right] = seq++;
            }
            right--;
            for (int i = 0; right-i>=left; i++) {
                res[bottom][right-i] = seq++;
            }
            bottom--;
            for (int i = 0; bottom-i>=top; i++) {
                res[bottom-i][left] = seq++;
            }
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        
        Solution s = new Solution();
        int[][] res = s.generateMatrix(1);
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }

}
