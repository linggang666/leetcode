package p112;

public class V1 {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		return _hasPathSum(root, sum, 0);
				
	}
	
	private boolean _hasPathSum(TreeNode n, int sum, int curSum){
		curSum += n.val;
		
		return (n.left == null && n.right == null && sum == curSum) ||
				(n.left != null && _hasPathSum(n.left, sum, curSum)) || 
				(n.right != null && _hasPathSum(n.right, sum, curSum));
	}
}
