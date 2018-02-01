package p018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

    /**
     * 基于3sum实现
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            
            List<List<Integer>> temp = this.threeSum(nums, i+1, nums.length-1, target-nums[i]);
            for (int j = 0; j < temp.size(); j++) {
                temp.get(j).add(nums[i]);
                res.add(temp.get(j));
            }
        }
        return res;
    }

    private List<List<Integer>> threeSum(int[] nums, int left, int right, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for (int i = left; i < right; i++) {
            if(i>left && nums[i]==nums[i-1]) {
                continue;
            }
            
            int l=i+1, r=right;
            while(l<r) {
                int sum = nums[l]+nums[r]+nums[i];
                if(sum == target) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    temp.add(nums[i]);
                    res.add(temp);
                    
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }else if(sum<target){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        V1 v = new V1();
        
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = v.fourSum(nums, 0);
        for(List<Integer> l : res) {
            System.out.println(l.toString());
        }
    }

}
