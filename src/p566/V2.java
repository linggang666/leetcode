package p566;

import java.util.Arrays;

public class V2 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(nums == null || nums.length==0 || nums[0].length==0 || nums.length*nums[0].length != r*c){
            return nums;
        }
        
        int[][] res = new int[r][c];
        int count = 0;
        for(int[] rowVal : nums){
            for(int val : rowVal){
                res[count/c][count%c] = val;
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {3,4}
        };
        V2 v = new  V2();
        int[][] res = v.matrixReshape(arr, 1, 3);
        for(int[] i : res){
            System.out.println(Arrays.toString(i));
        }
    }
}
