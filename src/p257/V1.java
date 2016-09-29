package p257;

import java.util.ArrayList;
import java.util.List;

public class V1 {

	List<String> paths = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null)
			return paths;

		_getPaths(root, "");
		return this.paths;

	}

	private void _getPaths(TreeNode n, String prePath) {
		if (n.left == null && n.right == null) this.paths.add(prePath+n.val);
		if (n.left != null) _getPaths(n.left, prePath+n.val+"->");
		if (n.right != null) _getPaths(n.right, prePath+n.val+"->");
	}
}
