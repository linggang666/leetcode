package p129;

public class V2 {
	public int sumNumbers(TreeNode root) {
		return traverse(root,0);
	}

	private int traverse(TreeNode root, int i) {
		if(root == null) return 0;
		
		int cur = i*10+root.val;
		if(root.left==null && root.right==null){
			return cur;
		}
		return traverse(root.left, cur) + traverse(root.right, cur);
	}
}
