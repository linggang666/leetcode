package p206;

public class Main {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode head = (new V22()).reverseList(l1);
		
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}

	}

}
