package p145;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		res.addAll(this.postorderTraversal(root.left));
		res.addAll(this.postorderTraversal(root.right));
		res.add(root.val);
		return res;
	}
}
