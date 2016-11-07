package p023;

public class V1 {
	
	/**
	 * 分治 14ms
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) 
			return null;
		return mergeSort(lists, 0, lists.length-1);
	}

	private ListNode mergeSort(ListNode[] lists, int l, int r) {
		if(l > r) return null;
		if(l == r) return lists[l];
		
		int mid = l+(r-l)/2;
		ListNode left = mergeSort(lists, l, mid);
		ListNode right = mergeSort(lists, mid+1, r);
		
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		while(left!=null && right!=null){
			if(left.val<=right.val){
				cur.next = left;
				left = left.next;
			}else{
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
				
		if(left!=null) cur.next = left;
		if(right!=null) cur.next = right;
		
		return pre.next;
	}
}
