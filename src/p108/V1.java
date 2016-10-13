package p108;

public class V1 {
	public TreeNode sortedArrayToBST(int[] nums) {
		return _sortedArrayToBST(nums, 0, nums.length-1);
	}

	private TreeNode _sortedArrayToBST(int[] nums, int l, int r) {
		if(l > r) return null;
		
		int mid = l + (r-l)/2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = _sortedArrayToBST(nums, l, mid-1);
		node.right = _sortedArrayToBST(nums, mid+1, r);
		
		return node;
	}
}
