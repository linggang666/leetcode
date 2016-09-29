package p104;

public class V1 {
	
	public int maxDepth(TreeNode root) {
		if(root == null){
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
