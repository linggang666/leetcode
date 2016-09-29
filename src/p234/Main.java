package p234;

public class Main {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		System.out.println((new V1()).isPalindrome(n1));
	}

}
