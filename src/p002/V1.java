package p002;

/**
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) × Output: 7 -> 0 -> 8
 */
public class V1 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode head = null,curNode = null;
		int r = 0;
		while(l1 != null && l2!=null){
			int v = l1.val+l2.val + r;
			r = v / 10;
			v = v % 10;
			if(head == null){
				head = new ListNode(v);
				curNode = head;
			}else{
				curNode.next = new ListNode(v);
				curNode = curNode.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		
		ListNode temp = l1 == null? l2: l1;
		while(temp != null){
			int v = temp.val + r;
			r = v / 10;
			v = v % 10;
			curNode.next = new ListNode(v);
			curNode = curNode.next;
			temp = temp.next;
		}
		
		if(r != 0){
			curNode.next = new ListNode(r);
		}
		
		return head;
	}
}

