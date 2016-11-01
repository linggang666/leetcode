package p113;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class V1 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		_pathSum(root, sum, 0, res, new ArrayList<>());
		return res;
	}

	private void _pathSum(TreeNode root, int sum, int curSum, List<List<Integer>> res, List<Integer> temp) {
		if(root == null) return;

		curSum += root.val;
		temp.add(root.val);
		if(root.left==null && root.right==null){
			if(curSum == sum){
				res.add(new ArrayList<>(temp));
			}
		}else{
			_pathSum(root.left, sum, curSum, res, temp);
			_pathSum(root.right, sum, curSum, res, temp);
		}
		curSum -= root.val;
		temp.remove(temp.size()-1);
	}
}
