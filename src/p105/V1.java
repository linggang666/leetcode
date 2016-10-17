package p105;

public class V1 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length==0) return null;
		return _buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length);
	}

	private TreeNode _buildTree(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
		if(iL>iR) return null;
		if(iL == iR) return new TreeNode(inorder[iL]);
		
		TreeNode node = new TreeNode(preorder[pL]);
		int i = iL;
		while(inorder[i]!=preorder[pL]) i++;
		node.left = _buildTree(preorder, pL+1, pL+i-iL, inorder, iL, i-1);
		node.right = _buildTree(preorder, pL+i-iL+1, pR, inorder, i+1, iR);
		
		return node;
	}
}
