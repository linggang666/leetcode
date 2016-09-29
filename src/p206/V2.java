package p206;

public class V2 {

	/**
	 * 递归
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null){
			return null;
		}
		if ( head.next != null) {
			ListNode next = head.next;
			ListNode r = reverseList(next);
			next.next = head;
			if(head.next == next){
				head.next = null;
			}
			return  r;
		}else{
			return head;
		}
	}
}
