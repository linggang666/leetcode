package p173;
import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
	
	Queue<Integer> queue = new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {
        midTraverse(root);
    }

    private void midTraverse(TreeNode root) {
    	if(root == null) return;
    	midTraverse(root.left);
    	queue.add(root.val);
    	midTraverse(root.right);
	}

	public boolean hasNext() {
        return !queue.isEmpty();
    }

    public int next() {
        return queue.poll();
    }
}