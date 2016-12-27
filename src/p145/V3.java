package p145;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class V3 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		TreeNode last = root;
		while(!stack.empty()){
			TreeNode top = stack.peek();
			if((top.left==null && top.right==null) || (top.right==null && last ==top.left) || last==top.right){
				res.add(top.val);
				last = top;
				stack.pop();
			}else{
				if(top.right !=null){
					stack.add(top.right);
				}
				if(top.left != null){
					stack.add(top.left);
				}
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		V3 v2 = new V3();
		v2.postorderTraversal(n1);
	}
}
