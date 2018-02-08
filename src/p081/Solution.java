package p081;

public class Solution {

    public boolean search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        
        while(l<=r) {
            int m = l+(r-l)/2;
            if(nums[m] == target) {
                return true;
            }
            
            while(l<m && nums[l] == nums[m]) l++;
            while(r>m && nums[r] == nums[m]) r--;
            
            if(nums[m]>=nums[l]) {
                if(nums[m] > target && nums[l]<=target) {
                    r=m-1;
                }else {
                    l=m+1;
                }
            }else {
                if(nums[m] < target && nums[r]>=target) {
                    l = m+1;
                }else {
                    r = m-1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Solution s = new Solution() ;
        
        int[] nums = {1,3,1,1,1};
        System.out.println(s.search(nums, 3));
    }

}
