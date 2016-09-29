package p118;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j <= i; j++) {
				if(j == 0 || j==i){
					list.add(1);
				}else{
					list.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
				}
			}
			result.add(list);
		}
		return result;
	}
}
