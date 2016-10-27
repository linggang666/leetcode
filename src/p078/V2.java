package p078;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V2 {
	
	/**
	 * 按位操作
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int len = nums.length;
        int cnt = (int) Math.pow(2, len);  
        for (int i = 0; i < cnt; i++) {
        	List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < len; j++) {
				if(((i>>j)&1)>0) temp.add(nums[j]);
			}
			ans.add(temp);
		}
        return ans;  
	}

	public static void main(String[] args) {
		V2 v = new V2();
		int[] a = {1,2,3};
		List<List<Integer>> subsets = v.subsets(a);
		for (int i = 0; i < subsets.size(); i++) {
			System.out.println(Arrays.toString(subsets.get(i).toArray()));
		}
	}
}
