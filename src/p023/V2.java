package p023;

import java.util.ArrayList;
import java.util.List;

public class V2 {
	
	/**
	 * heap use list 25ms
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) 
			return null;
		
		List<ListNode> heap = new ArrayList<>();
		for (int i = 0; i < lists.length; i++) {
			while(lists[i] != null){
				insertHeap(heap,lists[i]);
				lists[i] = lists[i].next;
			}
		}
		
		int len = heap.size()-1;
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		while(len >= 0){
			cur.next = heap.get(0);
			swap(heap, 0, len);
			adjustHeap(heap, 0, --len);
			cur = cur.next;
		}
		cur.next = null;
		
		return pre.next;
	}

	private void adjustHeap(List<ListNode> heap, int i, int len) {
		int minIndex = i;
		if(2*i+1<=len && heap.get(minIndex).val > heap.get(2*i+1).val){
			minIndex = 2*i+1;
		}
		if(2*i+2<=len && heap.get(minIndex).val > heap.get(2*i+2).val){
			minIndex = 2*i+2;
		}
		if(minIndex != i){
			swap(heap, minIndex, i);
			adjustHeap(heap, minIndex, len);
		}
	}

	private void insertHeap(List<ListNode> heap, ListNode node) {
		heap.add(node);
		
		int i = heap.size()-1;
		while(i>0 && heap.get((i-1)/2).val>node.val){
			swap(heap, (i-1)/2, i);
			i = (i-1)/2;
		}
	}

	private void swap(List<ListNode> heap, int i, int i2) {
		ListNode t = heap.get(i);
		heap.set(i, heap.get(i2));
		heap.set(i2, t);
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
		
		ListNode[] arr = {l12, l21};
		V2 v = new V2();
		v.mergeKLists(arr);
	}
}
