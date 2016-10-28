package p116;

public class V2 {
	public void connect(TreeLinkNode root) {
		if(root == null || root.left==null) return;
		root.left.next = root.right;
		connect(root.left);
		if(root.next != null)
			root.right.next = root.next.left;
		connect(root.right);
    }
}
