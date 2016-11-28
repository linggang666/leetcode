package p040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class V1 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		_combination(candidates, target, 0, res, new ArrayList<Integer>(),new HashSet<String>());
		return res;
	}

	private void _combination(int[] candidates, int target,int i, List<List<Integer>> res, ArrayList<Integer> temp, HashSet<String> uniqueSet) {
		if(target == 0){
			StringBuilder sb = new StringBuilder();
			for (Integer t : temp) {
				sb.append(t).append("-");
			}
			if(uniqueSet.add(sb.toString())){
				res.add(new ArrayList<>(temp));
			}
			return;
		}
		
		for (int j = i; j < candidates.length; j++) {
			if(target >= candidates[j]){
				temp.add(candidates[j]);
				_combination(candidates, target-candidates[j], j+1, res, temp, uniqueSet);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {10, 1, 2, 7, 6, 1, 5};
		V1 v = new V1();
		v.combinationSum2(a, 8);
	}
}
