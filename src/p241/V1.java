package p241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();
		
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if(c=='+' || c=='-' || c=='*'){
				List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
				List<Integer> rightRes = diffWaysToCompute(input.substring(i+1, input.length()));
				for (int j = 0; j < leftRes.size(); j++) {
					for (int j2 = 0; j2 < rightRes.size(); j2++) {
						switch (c) {
						case '+':
							res.add(leftRes.get(j)+rightRes.get(j2));
							break;
						case '-':
							res.add(leftRes.get(j)-rightRes.get(j2));
							break;
						case '*':
							res.add(leftRes.get(j)*rightRes.get(j2));
							break;
						}
					}
				}
			}
		}
		if(res.size() == 0){
			res.add(Integer.valueOf(input));
		}
		return res;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(Arrays.toString(v.diffWaysToCompute("2*3-4*5").toArray()));
	}
}
