package p203;

public class V1 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode pre = temp;

		while (temp.next != null) {
			if (temp.next.val == val) {
				temp.next = temp.next.next;
			}else{
				temp = temp.next;
			}
		}

		return pre.next;
	}
}
