package p111;

public class V1 {

	public int minDepth(TreeNode root) {
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		
		int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
		if(root.left != null){
			ld = minDepth(root.left);
		}
		if(root.right != null){
			rd = minDepth(root.right);
		}
		
		return 1 + Math.min(ld, rd);
	}
}
