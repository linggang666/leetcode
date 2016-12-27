package p145;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class V2 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		Set<TreeNode> set = new HashSet<>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode top = stack.peek();
			while(top.left!=null && !set.contains(top.left)){
				stack.push(top.left);
				top = top.left;
			}
			
			if(top.right != null && !set.contains(top.right)){
				stack.add(top.right);
			}else{
				TreeNode pop1 = stack.pop();
				res.add(pop1.val);
				set.add(pop1);
				while(!stack.empty() && pop1 == stack.peek().right){
					pop1 = stack.pop();
					res.add(pop1.val);
					set.add(pop1);
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
		V2 v2 = new V2();
		v2.postorderTraversal(n1);
	}
}
