package p078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> temp = new ArrayList<>();
	
	public List<List<Integer>> subsets(int[] nums) {
		res.clear();
		for (int i = 0; i <= nums.length; i++) {
			traverse(nums,0, i);
		}
		return res;
	}

	private void traverse(int[] nums, int left, int cnt) {
		if(temp.size() == cnt){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = left; i < nums.length; i++) {
			temp.add(nums[i]);
			traverse(nums, i+1, cnt);
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		int[] a = {1,2,3};
		List<List<Integer>> subsets = v.subsets(a);
		for (int i = 0; i < subsets.size(); i++) {
			System.out.println(Arrays.toString(subsets.get(i).toArray()));
		}
	}
}
