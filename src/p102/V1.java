package p102;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this._levelOrder(root,0, result);
		return result;
	}
	
	private void _levelOrder(TreeNode n, int level, List<List<Integer>> list){
		if(n == null){
			return;
		}
		if(list.size() <= level){
			list.add(new ArrayList<Integer>());
		}
		
		list.get(level).add(n.val);
		_levelOrder(n.left, level+1, list);
		_levelOrder(n.right, level+1, list);
	}
}
