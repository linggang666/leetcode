package p034;

import java.util.Arrays;

public class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) {
            return res;
        }
        
        int l=0, r=nums.length-1, mid=0;
        while(l<=r) {
            mid = l+(r-l)/2;
            if(nums[mid] == target) {
                break;
            }else if(nums[mid] < target) {
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        
        if(nums[mid] != target) {
            return res;
        }
        
        res[0]= mid;
        res[1]= mid;
        while(res[0]>0 && nums[res[0]-1]==target) res[0]--;
        while(res[1]<nums.length-1 && nums[res[1]+1]==target) res[1]++;
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Solution s = new Solution();
        
        System.out.println(Arrays.toString(s.searchRange(nums, 6)));
        System.out.println(Arrays.toString(s.searchRange(nums, 5)));
        System.out.println(Arrays.toString(s.searchRange(nums, 10)));
        System.out.println(Arrays.toString(s.searchRange(nums, 7)));
    }
}
