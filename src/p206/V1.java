package p206;

public class V1 {

	/**
	 * 循环
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		ListNode head1 = head, result=null;
		while(head1 != null){
			ListNode tmp = new ListNode(head1.val);
			tmp.next = result;
			result = tmp;
			head1 = head1.next;
		}
		return result;
	}
}
