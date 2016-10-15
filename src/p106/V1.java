package p106;

public class V1 {
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null || inorder.length == 0) return null;
		return _buildTree(inorder, 0,inorder.length-1, postorder, 0, postorder.length-1);
	}

	private TreeNode _buildTree(int[] inorder, int inL, int inR, int[] postorder, int postL, int postR) {
		
		TreeNode node = new TreeNode(postorder[postR]);
		int nodeI = 0;
		for (int i = inL;  i<= inR; i++) {
			if(inorder[i] == postorder[postR]){
				nodeI = i;
				break;
			}
		}
		
		if(nodeI != inL){
			node.left = _buildTree(inorder, inL, nodeI-1, postorder, postL, postL+nodeI-inL-1);
		}
		if(nodeI != inR){
			node.right = _buildTree(inorder, nodeI+1, inR, postorder, postL+nodeI-inL, postR-1);
		}
		return node;
	}
	
	public static void main(String[] args) {
		int[] in = {4,2,1,5,6,3};
		int[] post = {4,2,6,5,3,1};
		V1 v = new V1();
		v.buildTree(in, post);
	}
}
