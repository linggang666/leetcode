package p019;

public class V3 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(0);
		ListNode temp = node;
		node.next = head;
		
		int i=0;
		while(head != null){
			if(i == n){
				temp = temp.next;
			}else{
				i++;
			}
			head = head.next;
		}
		temp.next = temp.next.next;
		
		return node.next;
	}
}
