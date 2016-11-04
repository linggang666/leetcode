package p109;

public class V1 {
	public TreeNode sortedListToBST(ListNode head) {
		if(head == null) 
			return null;
		if(head.next == null) 
			return new TreeNode(head.val);
		
		ListNode fast = head.next.next, slow = head.next, leftTail = head;
		while(fast!= null && fast.next!=null && fast.next.next!=null){
			leftTail = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		leftTail.next = null;
		
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);
		return root;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		V1 v = new V1();
		TreeNode root = v.sortedListToBST(l1);
		System.out.println("ok");
	}
}
