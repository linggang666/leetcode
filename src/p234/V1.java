package p234;

public class V1 {
	public boolean isPalindrome(ListNode head) {
		if(head == null) return true;
		
		ListNode temp = head;
		int linkLen = 0;
		while (temp!=null){
			linkLen ++ ;
			temp = temp.next;
		}
		
		int[] arr = new int[linkLen];
		int i = 0;
		temp = head;
		while (temp!=null){
			arr[i++] = temp.val;
			temp = temp.next;
		}
		
		int arrLen = arr.length;
		for (i = 0; i < arrLen/2; i++) {
			if(arr[i] != arr[arrLen-i-1]){
				return false;
			}
		}
		
		return true;
	}
}
