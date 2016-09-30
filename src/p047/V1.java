package p047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class V1 {
	
	/**
	 * [2,2,1,1]
	 */
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		_permuteUnique(nums, 0);
		return list;
	}
	
	private void _permuteUnique(int[] nums, int i){
		if(i == nums.length-1){
			List<Integer> l = new ArrayList<Integer>();
			for (int n : nums) l.add(n);
			list.add(l);
			return;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		for (int j = i; j < nums.length; j++) {
			if(set.add(nums[j])){
				swap(nums, i, j);
				_permuteUnique(nums, i+1);
				swap(nums, j, i);
			}
		}
	}
	
	private void swap(int[] nums, int a,int b){
		int t = nums[a];
		nums[a] = nums[b];
		nums[b] = t;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		int[] a = {2,2,1,1};
		v.permuteUnique(a);
	}
}
