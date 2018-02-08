package p080;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int n=0;
        for (int i: nums) {
            if(n<2 || i>nums[n-2])
                nums[n++] = i;
        }
        return n;
    }
    
    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        int[] nums = {1,1,1,2,2,2,2,3,3};
        System.out.println(s.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
