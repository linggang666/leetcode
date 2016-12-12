package p095;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	public List<TreeNode> generateTrees(int n) {
		if(n<1) return new ArrayList<TreeNode>();
		return _generateTrees(1, n);
	}

	private List<TreeNode> _generateTrees(int start, int end) {
		List<TreeNode> res = new ArrayList<>();
		if(start > end){
			res.add(null);
			return res;
		}
		for (int i = start; i <= end; i++) {
			for(TreeNode l:_generateTrees(start, i-1)){
				for(TreeNode r:_generateTrees(i+1, end)){
					TreeNode t = new TreeNode(i);
					t.left = l;
					t.right = r;
					res.add(t);
				}
			}
		}
		return res;
	}
}
