package p382;

import java.util.Random;

public class Solution {

	private int len=0;
	private ListNode head;
	public Solution(ListNode head) {
		this.head = head;
		while(head != null){
			this.len++;
			head = head.next;
		}
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int i = (new Random()).nextInt(this.len)+1;
		ListNode node = this.head;
		while(i-->1){
			node = node.next;
		}
		return node.val;
	}

	public static void main(String[] args) {
//		System.out.println((new Random()).nextInt(2));
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		Solution solution = new Solution(head);
		
		System.out.println(solution.getRandom());;
		System.out.println(solution.getRandom());;
		System.out.println(solution.getRandom());;
	}

}
