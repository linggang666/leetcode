package p040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class V2 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		_combination(candidates, target, 0, res, new ArrayList<Integer>());
		return res;
	}

	private void _combination(int[] candidates, int target,int i, List<List<Integer>> res, ArrayList<Integer> temp) {
		if(target == 0){
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for (int j = i; j < candidates.length; j++) {
			if(j>i && candidates[j]==candidates[j-1]) 
				continue;
			if(target >= candidates[j]){
				temp.add(candidates[j]);
				_combination(candidates, target-candidates[j], j+1, res, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {10, 1, 2, 7, 6, 1, 5};
		V2 v = new V2();
		v.combinationSum2(a, 8);
	}
}
