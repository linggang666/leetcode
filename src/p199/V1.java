package p199;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	List<Integer> list = new ArrayList<Integer>();
	public List<Integer> rightSideView(TreeNode root) {
		list.clear();
		_rightSideView(root, 0);
		return list;
	}
	
	private void _rightSideView(TreeNode root, int level){
		if(root == null) return;
		
		if(list.size() <= level){
			list.add(root.val);
		}else{
			list.set(level, root.val);
		}
		
		_rightSideView(root.left, level+1);
		_rightSideView(root.right, level+1);
	}
}
