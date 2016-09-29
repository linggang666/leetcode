package p206;

public class V22 {

	/**
	 * 递归
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode r = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return r;
	}
}
