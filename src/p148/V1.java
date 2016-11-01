package p148;

public class V1 {
	public ListNode sortList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode right = sortList(slow.next);
		slow.next = null;
		ListNode left = sortList(head);
		
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		while(left != null && right !=null){
			if(left.val > right.val){
				cur.next = right;
				right = right.next;
			}else{
				cur.next = left;
				left = left.next;
			}
			cur = cur.next;
		}
		if(left!=null) cur.next = left;
		if(right!=null) cur.next = right;
		
		return pre.next;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		V1 v = new V1();
		ListNode res = v.sortList(l1);
		while(res != null){
			System.out.println(res.val);
			res = res.next;
		}
	}
}
