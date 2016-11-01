package p077;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(n>=k) 
			_combine(1,n,k,res,new ArrayList<Integer>());
		return res;
	}

	private void _combine(int from,int n, int k,  List<List<Integer>> res, ArrayList<Integer> temp) {
		if(temp.size() == k){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		
		for (int i = from; i <= n; i++) {
			temp.add(i);
			_combine(i+1, n, k, res, temp);
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		List<List<Integer>> res = v.combine(4, 2);
		for (List<Integer> i: res) {
			System.out.println(Arrays.toString(i.toArray()));
		}
	}
}
