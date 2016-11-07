package p023;

public class V3 {
	
	/**
	 * heap use array 24ms
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) 
			return null;
		
		int len = 0;
		for (int i = 0; i < lists.length; i++) {
			ListNode temp = lists[i];
			while(temp != null){
				len++;
				temp = temp.next;
			}
		}
		
		ListNode[] heap = new ListNode[len];
		int size = 0;
		for (int i = 0; i < lists.length; i++) {
			while(lists[i] != null){
				insertHeap(heap,lists[i],size++);
				lists[i] = lists[i].next;
			}
		}
		
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		while(len > 0){
			cur.next = heap[0];
			swap(heap, 0, --len);
			adjustHeap(heap, 0, len-1);
			cur = cur.next;
		}
		cur.next = null;
		
		return pre.next;
	}

	private void insertHeap(ListNode[] heap, ListNode node, int i) {
		heap[i] = node;
		
		while(i>0 && heap[(i-1)/2].val>node.val){
			swap(heap, (i-1)/2, i);
			i = (i-1)/2;
		}
	}

	private void adjustHeap(ListNode[] heap, int i, int len) {
		int minIndex = i;
		if(2*i+1<=len && heap[minIndex].val > heap[2*i+1].val){
			minIndex = 2*i+1;
		}
		if(2*i+2<=len && heap[minIndex].val > heap[2*i+2].val){
			minIndex = 2*i+2;
		}
		if(minIndex != i){
			swap(heap, minIndex, i);
			adjustHeap(heap, minIndex, len);
		}
	}

	private void swap(ListNode[] heap, int i, int i2) {
		ListNode t = heap[i];
		heap[i] = heap[i2];
		heap[i2] = t;
	}

	public static void main(String[] args) {
		ListNode l11 = new ListNode(7);
		ListNode l12 = new ListNode(8);
		l11.next = l12;
		
		ListNode l21 = new ListNode(2);
		ListNode l24 = new ListNode(4);
		ListNode l25 = new ListNode(5);
		ListNode l26 = new ListNode(6);
		ListNode l29 = new ListNode(9);
		l21.next = l24;
		l24.next = l25;
		l25.next = l26;
		l26.next = l29;
		
		ListNode[] arr = {l11, l21};
		V3 v = new V3();
		v.mergeKLists(arr);
	}
}
