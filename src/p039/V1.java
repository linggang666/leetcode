package p039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		_combinationSum(candidates, 0, 0, target, res, new ArrayList<Integer>());
		return res;
    }

	private void _combinationSum(int[] candidates, int start, int curSum, int target, List<List<Integer>> res, ArrayList<Integer> temp) {
		if(curSum==target){
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			if(candidates[i]+curSum > target)
				return;
			
			temp.add(candidates[i]);
			_combinationSum(candidates, i, curSum+candidates[i], target, res, temp);
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,7};
		V1 v = new V1();
		v.combinationSum(arr, 7);
	}
}
