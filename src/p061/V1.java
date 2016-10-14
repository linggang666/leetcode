package p061;

public class V1 {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next==null) return head;
		
		ListNode temp = head;
		int len=1;
		while(temp.next!=null){
			len++;
			temp = temp.next;
		}
		
		k = k%len;
		if(k==0) return head;
		
		temp.next = head;
		temp = head;
		int i = len-k-1;
		while(i-->0) temp = temp.next;
		
		head = temp.next;
		temp.next=null;
		return head;
	}
}
