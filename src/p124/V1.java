package p124;

public class V1 {
	public int maxPathSum(TreeNode root) {
		int[] res = getRes(root);
		return res[0];
	}

	private int[] getRes(TreeNode root) {
		if(root == null){
			return new int[]{Integer.MIN_VALUE, 0};  
		}
		int[] leftRes = getRes(root.left);
		int[] rightRes = getRes(root.right);
		
		int max = root.val, childMax=root.val;
		max = Math.max(max, max+leftRes[1]);
		max = Math.max(max, max+rightRes[1]);
		max = Math.max(max, rightRes[0]);
		max = Math.max(max, leftRes[0]);
		
		childMax = Math.max(childMax, root.val + leftRes[1]);
		childMax = Math.max(childMax, root.val + rightRes[1]);
		
		return new int[]{max, childMax};
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(-3);
		TreeNode t4 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		V1 v = new V1();
		System.out.println(v.maxPathSum(t1));
		
	}
}
