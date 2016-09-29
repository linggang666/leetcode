package p002;

public class Main {
	//(2 -> 4 -> 6) + (5 -> 6 -> 4)
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(6);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode r = (new V2()).addTwoNumbers(l1, l2);
		while(r != null){
			System.out.println(r.val);
			r = r.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
