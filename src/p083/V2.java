package p083;

public class V2 {
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode cur = head;
		while(cur != null && cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		return head;
	}
}
