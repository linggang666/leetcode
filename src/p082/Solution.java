package p082;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode p = pre;
        
        while(head!=null) {
            if(head.next==null || head.val!=head.next.val) {
                p.next = head;
                p = p.next;
                head = head.next;
            }else {
                int delNum = head.val;
                while(head!=null && head.val==delNum) {
                    head = head.next;
                }
            }
        }
        p.next = null;
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        
        Solution s = new Solution();
        ListNode res = s.deleteDuplicates(l1);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
