package p098;

public class V2 {
	
	public boolean isValidBST(TreeNode root) {
        return dfs(root, (long)(Integer.MIN_VALUE)-1, (long)(Integer.MAX_VALUE)+1);
    }
    private boolean dfs(TreeNode root, long gt, long lt){
        if(root == null) return true;
        if(root.val >= lt || root.val <= gt) return false;
        return dfs(root.left, gt, root.val) && dfs(root.right, root.val, lt);
    }
	
}
