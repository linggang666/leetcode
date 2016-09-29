package p216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class V1 {
	
	private List<List<Integer>> result = new ArrayList<List<Integer>>();
	private Set<Integer> set = new HashSet<Integer>();
	
	public List<List<Integer>> combinationSum3(int k, int n) {
		_combinationSum(k, n, 1);
		return result;
	}
	
	private void _combinationSum(int _k, int _n, int _pos){
		if(_n<=0) return;
		
		if(_k == 1 && _n>=_pos && _n<=9){
			set.add(_n);
			result.add(new ArrayList<Integer>(set));	
			set.remove(_n);
			return;
		}
		
		for (int pos = _pos; pos < 10; pos++) {
			if(10-pos<_k || _n<pos) return;
			set.add(pos);
			_combinationSum(_k-1, _n-pos, pos+1);
			set.remove(pos);
		}
		
	}

	public static void main(String[] args) {
		List a = (new V1()).combinationSum3(2, 10);
		System.out.println(Arrays.toString(a.toArray()));
	}

}
