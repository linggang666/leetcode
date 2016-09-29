package p101;

import java.util.LinkedList;
import java.util.Queue;

public class V2 {
	public boolean isSymmetric(TreeNode root) {
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while(!q.isEmpty()){
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if(t1 == null && t2 == null) return true;
			if(t1 == null || t2 == null || t1.val!=t2.val) return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}
}
