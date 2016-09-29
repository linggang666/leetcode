package p103;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	private List<List<Integer>> list = new ArrayList<List<Integer>>();
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		list.clear();
		_zigzagLevelOrder(root, 1);
		return list;
	}

	public void _zigzagLevelOrder(TreeNode root, int level) {
		if(root == null) return;
		if(list.size()<level){
			list.add(new ArrayList<>());
		}
		
		if(level%2 == 0){
			list.get(level-1).add(0, root.val);
		}else{
			list.get(level-1).add(root.val);
		}
		
		_zigzagLevelOrder(root.left, level+1);
		_zigzagLevelOrder(root.right, level+1);
		
	}
}
