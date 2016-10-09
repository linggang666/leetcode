package p114;

public class V2 {
	
	public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        if(left != null){
            root.right = left;
            TreeNode temp = left;
            while(temp!=null && temp.right!=null) temp = temp.right;
            temp.right = right;
        }
    }
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		
		V2 v = new V2();
		v.flatten(n1);
	}
}
