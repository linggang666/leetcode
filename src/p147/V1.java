package p147;

public class V1 {
	public ListNode insertionSortList(ListNode head) {
        
		if(head==null || head.next==null) return head;
		
		ListNode pre = new ListNode(0);
		ListNode cur = head;
		while (cur!=null) {
			ListNode temp = cur.next;
			ListNode pre1 = pre;
			while(pre1.next != null && pre1.next.val<cur.val){
				pre1 = pre1.next;
			}
			if(pre1.next == null){
				pre1.next = cur;
				pre1.next.next = null;
			}else{
				cur.next = pre1.next;
				pre1.next = cur;
			}
			cur = temp;
		}
		return pre.next;
    }
}
