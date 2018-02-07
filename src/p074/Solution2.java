package p074;

public class Solution2 {

    
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length <1 || matrix[0].length<1) {
            return false;
        }
        
        int rows = matrix.length, cols=matrix[0].length;
        int l=0, r=rows*cols-1;
        while(l!=r) {
            int m = l+(r-l-1)/2;
            if(matrix[m/cols][m%cols] < target) {
                l = m+1;
            }else {
                r = m;
            }
        }
        return matrix[r/cols][r%cols] == target;
    }
    public static void main(String[] args) {
        
        Solution2 s = new Solution2();
        
        int[][] matrix = {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}};
        System.out.println(s.searchMatrix(matrix, 1));
    }

}
