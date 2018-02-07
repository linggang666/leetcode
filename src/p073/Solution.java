package p073;

import java.util.Arrays;

public class Solution {

    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1 || matrix[0].length<1) {
            return;
        }
        
        boolean col0is0 = false;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]==0) 
                col0is0=true;
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = matrix.length-1; i >=0; i--) {
            for (int j = matrix[0].length-1; j >0; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col0is0) matrix[i][0]=0;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
//        int[][] matrix = {{1,2,3,0,5},{1,2,3,4,5},{1,0,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
        int[][] matrix = {{1,0,1},{1,1,2}};
        
        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
        s.setZeroes(matrix);
        System.out.println();
        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
    }

}
