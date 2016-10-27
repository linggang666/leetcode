package p222;


public class V1 {
	
	public int countNodes(TreeNode root) {
        
		if(root == null) return 0;
		
		int lLevel = getLeftLevel(root);
		int rLevel = getRightLevel(root);
		
		if(lLevel == rLevel){
			return (2<<(lLevel-1)) - 1;
		}
		
		return countNodes(root.left)+countNodes(root.right)+1;
    }

	private int getLeftLevel(TreeNode node) {
		int cnt = 0;
		while(node != null){
			node = node.left;
			cnt++;
		}
		return cnt;
	}
	
	private int getRightLevel(TreeNode node) {
		int cnt = 0;
		while(node != null){
			node = node.right;
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left = n2;
		n1.right = n3;
		V1 v1 = new V1();
		System.out.println(v1.countNodes(n1));
	}
}
