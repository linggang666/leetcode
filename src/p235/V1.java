package p235;

public class V1 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || p == null || q == null){
			return null;
		}
		
		if(p.val > q.val){
			return lowestCommonAncestor(root, q, p);
		}
		
		if(root.val == p.val || root.val == q.val || (root.val>p.val && root.val<q.val)){
			return root;
		}
		
		if(root.val > q.val){
			return lowestCommonAncestor(root.left, p, q);
		}else{
			return lowestCommonAncestor(root.right, p, q);
		}
	}
}
