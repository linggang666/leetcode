package p025;

public class V1 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res=new ListNode(0);;
        ListNode resLast = res;
        
        ListNode p = head;;
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        
        ListNode pl, pr, pt;
        while ((cnt=cnt-k)>=0) {
            pr = head;
            pl = head;
            head = head.next;
            int i=0;
            while(++i<k) {
                pt = head.next;
                head.next = pl;
                pl = head;
                head = pt;
            }
            resLast.next = pl;
            resLast = pr;
        }
        
        resLast.next = head;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        
        V1 v = new V1();
        v.reverseKGroup(n1, 4);
    }

    private void printListNode(ListNode head) {
        System.out.print("\nlist nodes : ");
        while (head != null) {
            System.out.print(head.val + " ,");
            head = head.next;
        }
        System.out.println();
    }
}
