package p024;

public class V1 {
	public ListNode swapPairs(ListNode head) {
		ListNode h = new ListNode(0);
		ListNode curr = h, temp;
		while(head != null){
			if(head.next != null){
				temp = head.next.next;
				curr.next = head.next;
				curr.next.next = head;
				curr = curr.next.next;
				head = temp;
			}else{
				curr.next = head;
				head = head.next;
				curr = curr.next;
			}
			curr.next = null;
		}
		return h.next;
	}
}
