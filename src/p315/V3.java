package p315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V3 {

	private int smaller(Node node, int val) {
		node.count++;
		if (node.min == node.max)
			return 0;
		int m = (node.min + node.max) / 2;
		if (m < val) {
			if (node.right == null)
				node.right = new Node(m + 1, node.max);
			return node.count - 1 - node.right.count + smaller(node.right, val);
		} else if (m > val) {
			if (node.min == m)
				return 0;
			if (node.left == null)
				node.left = new Node(node.min, m - 1);
			return smaller(node.left, val);
		} else {
			if (node.left == null)
				return 0;
			return node.left.count;
		}
	}

	/**
	 * 分段树 ~~
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmaller(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		Node root = new Node(min, max);
		int[] smaller = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			smaller[i] = smaller(root, nums[i]);
		}
		List<Integer> result = new ArrayList<>(nums.length);
		for (int i = 0; i < smaller.length; i++)
			result.add(smaller[i]);
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 5, 2, 6, 1, 0 };
		V3 v = new V3();
		System.out.println(Arrays.toString(v.countSmaller(a).toArray()));
	}
}

class Node {
	int min, max;
	int count;
	Node left, right;

	Node(int min, int max) {
		this.min = min;
		this.max = max;
	}
}
