package p143;



public class V1 {
	public void reorderList(ListNode head) {
		if(head == null || head.next==null){
			return;
		}
		ListNode t1 = head, t2=head;
		while (t2.next!=null && t2.next.next!=null) {
			t1 = t1.next;
			t2 = t2.next.next;
		}
		t2 = t1.next;
		t1.next = null;
		
		t1 = t2.next;
		t2.next = null;
		while(t1 != null){
			ListNode t = t1.next;
			t1.next = t2;
			t2 = t1;
			t1 = t;
		}
		t1 = head;
		
		while (t1!=null && t2!=null) {
			ListNode tt1 = t1.next, tt2 = t2.next;
			t2.next = t1.next;
			t1.next = t2;
			t1 = tt1;
			t2 = tt2;
		}
	}

	public static void main(String[] args) {
		V1 v1 = new V1();
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		v1.reorderList(l1);
		System.out.println();
		while (l1!=null) {
			System.out.print(l1.val+"  ");
			l1 = l1.next;
		}
	}
}
