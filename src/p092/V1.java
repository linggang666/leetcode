package p092;

public class V1 {
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode pre1 = pre;
		
		int i=0;
		while(++i<m){
			pre1 = pre1.next;
			head = head.next;
		}
		ListNode tail = head;
		ListNode subHead = head;;
		head = head.next;
		while(i++<n){
			ListNode next = head.next;
			head.next = subHead;
			subHead = head;
			head = next;
		}
		tail.next = head;
		pre1.next = subHead;
		return pre.next;
	}
	
//	public static void main(String[] args) {
//		ListNode n1 = new ListNode(1);
//		ListNode n2 = new ListNode(2);
//		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
//		
//		V1 v = new V1();
//		ListNode res = v.reverseBetween(n1, 2, 5);
//		while (res!=null) {
//			System.out.print(res.val+",");
//			res = res.next;
//		}
//	}

}
