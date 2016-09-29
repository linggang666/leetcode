package p083;

import java.util.HashSet;
import java.util.Set;

public class V1 {
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null){
			return head;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		ListNode pre = null, cur = head;
		while(cur != null){
			if(set.contains(cur.val)){
				pre.next = cur.next;
			}else{
				set.add(cur.val);
				pre = cur;
			}
			cur = cur.next;
		}
		
		return head;
	}
}
