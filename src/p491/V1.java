package p491;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class V1 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<String> uniqueSet = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(nums[i]);
            _traversal(nums, i+1, temp, res, uniqueSet, nums[i]+"|");
        }
        return res;
    }

    private void _traversal(int[] nums, int i, List<Integer> temp, List<List<Integer>> res, Set<String> uniqueSet, String uniqueStr) {
        
        for (int j = i; j < nums.length; j++) {
            if(nums[j]>=temp.get(temp.size()-1) && uniqueSet.add(uniqueStr+nums[j]+"|")){
                temp.add(nums[j]);
                res.add(new ArrayList<>(temp));
                _traversal(nums, j+1, temp, res, uniqueSet, uniqueStr+nums[j]+"|");
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {3,5,3,7};
        V1 v = new V1();
        List<List<Integer>> res = v.findSubsequences(nums);
        for (List<Integer> list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
