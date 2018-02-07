package p074;

public class Solution {

    
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length <1 || matrix[0].length<1) {
            return false;
        }
        int top=0, bottom=matrix.length-1;
        int left=0, right=matrix[0].length-1;
        int inRow = -1;
        
        while(top <= bottom) {
            int m = top+(bottom-top)/2;
            if(matrix[m][left]<=target && matrix[m][right]>= target) {
                inRow = m;
                break;
            }
            if(matrix[m][left]>target) {
                bottom = m-1;
            }else {
                top = m+1;
            }
        }
        
        if(inRow==-1) {
            return false;
        }
        
        while(left <= right) {
            int m = left+(right-left)/2;
            if(matrix[inRow][m] == target) {
                return true;
            }
            if(matrix[inRow][m]>target) {
                right = m-1;
            }else {
                left = m+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
        Solution s = new Solution();
        
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(s.searchMatrix(matrix, 50));
    }

}
