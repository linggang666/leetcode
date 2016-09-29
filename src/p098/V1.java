package p098;

public class V1 {
	
	Integer pre = null;
	public boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		
		if(!isValidBST(root.left)) return false;
		if(pre != null && pre >= root.val){
			return false;
		}
		pre = root.val;
		return isValidBST(root.right);
	}
	
}
