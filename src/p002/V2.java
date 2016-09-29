package p002;

public class V2 {
	
	public ListNode addTwoNumbers(ListNode _l1, ListNode _l2) {
		if (_l1 == null) return _l2;
		if (_l2 == null) return _l1;

		ListNode head = new ListNode(0);
		ListNode curNode = head, l1=_l1, l2=_l2;
		
		int r = 0;
		while(l1 != null || l2!=null){
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;
			int v = x + y + r;
			r = v / 10;
			curNode.next = new ListNode(v % 10);
			curNode = curNode.next;
			
			l1 = l1.next;
			l2 = l2.next;
		}
		
		if(r != 0){
			curNode.next = new ListNode(r);
		}
		
		return head.next;
	}
}

