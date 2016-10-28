package p116;

public class V1 {
	public void connect(TreeLinkNode root) {
		if(root == null) return;
        TreeLinkNode pre, cur, temp = root;
        while(temp.left != null){
        		pre = temp;
        		cur = temp.left;
        		
        		while(pre != null){
        			if(cur == pre.left){
        				cur.next = pre.right;
        				cur = cur.next;
        			}else if(cur == pre.right){
        				if(pre.next != null){
        					pre = pre.next;
        					cur.next = pre.left;
        					cur = cur.next;
        				}else{
        					pre = null;
        				}
        			}
        		}
        		temp = temp.left;
        }
    }
}
