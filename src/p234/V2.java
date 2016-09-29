package p234;

public class V2 {
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;
		
		ListNode temp = head,tail = head, pre=null;
		int len = 0;
		while (temp!=null){
			len ++ ;
			temp = temp.next;
		}
		
		int i=0, m=len/2+len%2;
		while(tail.next != null){
			if(i++>=m){
				temp = tail.next;
				tail.next = pre;
				pre = tail;
				tail = temp;
			}else{
				tail = tail.next;
			}
		}
		tail.next = pre;
		
		while(tail != null){
			if(tail.val != head.val){
				return false;
			}
			tail = tail.next;
			head = head.next;
		}
		
		return true;
	}
}
