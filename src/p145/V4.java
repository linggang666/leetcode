package p145;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class V4 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		stack.add(root);
		TreeNode last;
		while(!stack.empty()){
			last = stack.pop();
			if(!stack.empty() && last==stack.peek()){
				if(last.right !=null){
					stack.push(last.right);
					stack.push(last.right);
				}
				if(last.left !=null){
					stack.push(last.left);
					stack.push(last.left);
				}
			}else{
				res.add(last.val);
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
		V4 v2 = new V4();
		List<Integer> postorderTraversal = v2.postorderTraversal(n1);
		System.out.println(Arrays.toString(postorderTraversal.toArray()));
	}
}
