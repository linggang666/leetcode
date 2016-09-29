package p024;

public class V2 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode second = head.next;
		head.next = second.next;
		second.next = head;
		head.next = swapPairs(head.next);
		return second;
	}
}
