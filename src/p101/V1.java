package p101;

public class V1 {
	public boolean isSymmetric(TreeNode root) {
		if(root == null ){
			return true;
		}
		return _isSymmetric(root.left, root.right);
	}
	
	private boolean _isSymmetric(TreeNode l, TreeNode r){
		if(l==null && r==null){
			return true;
		}
		if(l==null || r==null || l.val!=r.val){
			return false;
		}
		
		return _isSymmetric(l.right, r.left) && _isSymmetric(l.left, r.right);
	}
}
