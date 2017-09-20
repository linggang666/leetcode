package p566;

import java.util.Arrays;

public class V1 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length==0 || nums[0].length==0 || nums.length*nums[0].length != r*c){
            return nums;
        }
        
        int[][] res = new int[r][c];
        int ri=0, ci=0;
        for(int[] rowVal : nums){
            for(int val : rowVal){
                res[ri][ci] = val;
                ci++ ;
                if(ci==c){
                    ri++;
                    ci=0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {3,4}
        };
        V1 v = new  V1();
        int[][] res = v.matrixReshape(arr, 1, 3);
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
    }
}
