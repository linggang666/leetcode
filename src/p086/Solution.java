package p086;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode part1Pre = new ListNode(0);
        ListNode part2Pre = new ListNode(0);
        ListNode p1 = part1Pre, p2 = part2Pre;

        while (head != null) {
            if(head.val<x) {
                p1.next = head;
                p1 = p1.next;
            }else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        
        p1.next = part2Pre.next;
        p2.next = null;
        return part1Pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        ListNode l7 = new ListNode(0);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        
        Solution s = new Solution();
        ListNode res = s.partition(l1, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
