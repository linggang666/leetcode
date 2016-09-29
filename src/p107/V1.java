package p107;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class V1 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		traversalTree(root, 0, result);;
		Collections.reverse(result);
		return result;
	}
	
	private void traversalTree(TreeNode node, int level, List<List<Integer>> list){
		if(node == null){
			return;
		}
		if(list.size() <= level){
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(node.val);
		
		traversalTree(node.left, level+1, list);
		traversalTree(node.right, level+1, list);
	}
}
