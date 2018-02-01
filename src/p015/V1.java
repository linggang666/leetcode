package p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

    /**
     * two pointers
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        int len = nums.length;
        for (int i = 0; i < len-2 && nums[i]<1; i++) {
            if(i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            
            int l=i+1, r=len-1;
            while(l<r) {
                int sum = nums[l]+nums[r]+nums[i];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    temp.add(nums[i]);
                    res.add(temp);
                    
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }else if(sum<0){
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
        
        int[] nums = {-2,0,0,2,2};
        List<List<Integer>> res = v.threeSum(nums);
        for(List<Integer> l : res) {
            System.out.println(l.toString());
        }
    }

}
