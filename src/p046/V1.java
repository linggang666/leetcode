package p046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	
	List<List<Integer>> result = new ArrayList<>();
	List<Integer> temp = new ArrayList<>();
	public List<List<Integer>> permute(int[] nums) {
		this.result.clear();
		this.temp.clear();
		
		if(nums!=null && nums.length>0) {
			_permute(nums, temp, 0);
		}
		return this.result;
    }
	private void _permute(int[] nums, List<Integer> list, int start) {
		if(start == nums.length){
			System.out.println(Arrays.toString(list.toArray()));
			this.result.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = start; i < nums.length; i++) {
			swap(nums,start,i);
			list.add(nums[start]);
			_permute(nums, list, start+1);
			list.remove(list.size()-1);
			swap(nums, i, start);
		}
	}
	private void swap(int[] nums, int start, int i) {
		int t = nums[start];
		nums[start] = nums[i];
		nums[i] = t;
	}
	
	public static void main(String[] args) {
		V1 v1 = new V1();
		int[] a = {1,2,3,4};
		v1.permute(a);
	}
}
