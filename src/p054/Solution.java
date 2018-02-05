package p054;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import p650.V1;

public class Solution {
    
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length==0 || matrix[0].length==0) 
            return res;
        
        int top=0, right=matrix[0].length-1, bottom=matrix.length-1, left = 0;
        while (top<=bottom && left <= right) {
            for (int i = 0; left+i <= right && bottom>=top; i++)
                res.add(matrix[top][left+i]);
            top++;
            for (int i = 0; top+i <= bottom && right>=left; i++)
                res.add(matrix[top+i][right]);
            right--;
            for (int i = 0; right-i >= left && bottom>=top; i++)
                res.add(matrix[bottom][right-i]);
            bottom--;
            for (int i = 0; bottom-i >= top && right>=left; i++)
                res.add(matrix[bottom-i][left]);
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int row = 2, col = 3, t=1;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = t++;
            }
        }
        
        for (int[] is : matrix) {
            System.out.println(Arrays.toString(is));
        }
        
        Solution s = new Solution();
        System.out.println(s.spiralOrder(matrix));
    }

}
