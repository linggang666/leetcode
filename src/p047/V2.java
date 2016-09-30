package p047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class V2 {
	
	/**
     * If we are allowed to sort the array, we could sort the array to let the same number cluster together. 
     * In this way, avoiding duplicates, which is to avoid the same number being the first number in the permutation, is simplified bacause we can judge is a number is the same as its previous one and if its previous one has been used. 
     * We keep a boolean array to store the numbers being used, whose values are false originally. 
     * Each time we use a number, we set its corresponding value in boolean array to be true. 
     * And we try further down in the recursion. 
     * Once the recursion returns, we backtrack by changing its corresponding boolean value to be false and remove it from the current result.
     * O(n!) time, O(n) space.
     */
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;
        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        
        permuteHelper(nums, 0, ret, used, new ArrayList<Integer>());
        
        return ret;
    }
    
    private void permuteHelper(int[] nums, int len, List<List<Integer>> ret, boolean[] used, List<Integer> curr) {
        if (len == nums.length) {
        	//System.out.println(Arrays.toString(curr.toArray()));
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                    continue;
                }
                used[i] = true;
                curr.add(nums[i]);
                permuteHelper(nums, len + 1, ret, used, curr);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
	
	public static void main(String[] args) {
		V2 v = new V2();
		int[] a = {2,2,1,1};
		v.permuteUnique(a);
	}
}
