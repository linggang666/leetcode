package p016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

    /**
     * two pointers
     * @param nums
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        
        int len = nums.length;
        for (int i = 0; i < len-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int l=i+1, r=len-1;
            while(l<r) {
                int sum = nums[l]+nums[r]+nums[i];
                if(sum == target) {
                    return target;
                }
                if(Math.abs(res-target) > Math.abs(sum-target)) {
                    res = sum;
                }
                if(sum>target) {
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        V1 v = new V1();
        
        int[] nums = {-3,-2,-5,3,-4};
        int res = v.threeSumClosest(nums, -1);
        System.out.println(res);
    }

}
