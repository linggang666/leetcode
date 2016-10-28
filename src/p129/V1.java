package p129;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public int sumNumbers(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		traverse(root, sb, list);
		int res = 0;
		for(Integer i:list){
			res += i;
		}
		return res;
	}

	private void traverse(TreeNode root, StringBuilder sb, List<Integer> list) {
		if(root == null) return;
		sb.append(root.val);
		
		if(root.left==null && root.right==null){
			list.add(Integer.valueOf(sb.toString()));
		}else{
			traverse(root.left, sb, list);
			traverse(root.right, sb, list);
		}
		sb.deleteCharAt(sb.length()-1);
	}
}
