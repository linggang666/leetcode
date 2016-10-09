package p114;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	public void flatten(TreeNode root) {
		List<TreeNode> list = new ArrayList<>();
		traverseTree(root, list);
		
		int len = list.size();
		for (int i = 0; i < len; i++) {
			TreeNode node = list.get(i);
			node.left = null;
			if(i+1<len){
				node.right = list.get(i+1);
			}else{
				node.right = null;
			}
		}
	}
	
	private void traverseTree(TreeNode node, List<TreeNode> list){
		if(node == null) return;
		list.add(node);
		traverseTree(node.left, list);
		traverseTree(node.right, list);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		
		V1 v = new V1();
		v.flatten(n1);
	}
}
