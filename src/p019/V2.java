package p019;

public class V2 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(0);
		node.next = head;
		int len = 0;
		while(head != null){
			len++;
			head = head.next;
		}
		len = len - n + 1;
		
		head = node;
		int i=1;
		while(i++<len){
			head = head.next;
		}
		head.next = head.next.next;
		
		return node.next;
	}
}
