package p110;

import java.util.HashMap;
import java.util.Map;

public class V1 {

	private Map<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		if(Math.abs(getDepth(root.left) - getDepth(root.right)) > 1){
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	private int getDepth(TreeNode n){
		if(n == null) return 0;
		if(m.get(n) == null){
			int depth = Math.max(getDepth(n.left), getDepth(n.right)) + 1;
			m.put(n, depth);
		}
		return m.get(n);
	}
}
