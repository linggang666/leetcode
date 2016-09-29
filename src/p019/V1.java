package p019;

import java.util.Stack;

public class V1 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		Stack<ListNode> s = new Stack<>();
		while(head != null){
			s.add(head);
			head = head.next;
		}
		
		int i = 1;
		while(!s.empty()){
			ListNode t = s.pop();
			if(n != i++){
				t.next = head;
				head = t;
			}
		}
		
		return head;
	}
}
