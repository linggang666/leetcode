package p160;

public class V2 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB==null) return null;
		
		int lenA = this.getLinkLenght(headA);
		int lenB = this.getLinkLenght(headB);
		
		ListNode longLink, shortLink;
		int diffLen = 0;
		if(lenA > lenB){
			longLink = headA;
			shortLink = headB;
			diffLen = lenA - lenB;
		}else{
			longLink = headB;
			shortLink = headA;
			diffLen = lenB - lenA;
		}

		while(diffLen-- > 0){
			longLink = longLink.next;
		}
		
		while(longLink != null){
			if(longLink == shortLink){
				return longLink;
			}
			longLink = longLink.next;
			shortLink = shortLink.next;
		}
		
		return null;
	}
	
	private int getLinkLenght(ListNode head){
		int len = 0;
		ListNode temp = head;
		while(temp != null){
			len ++;
			temp = temp.next;
		}
		return len;
	}
}
