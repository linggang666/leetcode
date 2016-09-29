package p141;

import java.util.HashSet;
import java.util.Set;

public class V1 {

	public boolean hasCycle(ListNode head) {
		Set<ListNode> s = new HashSet<ListNode>();
		ListNode head1 = head;
		while(head1 != null){
			if(s.contains(head1)){
				return true;
			}
			s.add(head1);
			head1 = head1.next;
		}
		return false;
	}
}
