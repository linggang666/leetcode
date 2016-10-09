package p328;

public class V1 {
	public ListNode oddEvenList(ListNode head) {
		
		if(head == null || head.next == null) return head;
		
		int i=1;
		ListNode temp = head.next.next, oddTail = head, even = head.next, evenTail = head.next;
		while(temp != null){
			if((i++%2) == 0){
				evenTail.next = temp;
				evenTail = evenTail.next;
			}else{
				oddTail.next = temp;
				oddTail = oddTail.next;
			}
			temp = temp.next;
		}
		
		oddTail.next = even;
		evenTail.next = null;

		return head;
	}
}
