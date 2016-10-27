package p022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	
	/**
	 * @param n
	 * @see 卡塔兰数
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		traverse(n, n, new StringBuilder(), res);
		return res;
	}

	private void traverse(int left, int right, StringBuilder sb, List<String> res) {
		if(left==0 && right==0){
			res.add(sb.toString());
			return;
		}
		
		if(left!=0){
			sb.append('(');
			traverse(left-1, right, sb, res);
			sb.deleteCharAt(sb.length()-1);
		}
		if(right != 0 && left < right){
			sb.append(')');
			traverse(left, right-1, sb, res);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(Arrays.toString(v.generateParenthesis(4).toArray()));
	}
	
}
