package p297;

import java.util.Stack;

public class Codec {

	/**
	 * 采用先序遍历来记录，空节点为*s
	 * @param root
	 * @return
	 */
    public String serialize(TreeNode root) {
    	if(root == null){
    		return "*";
    	}
    	String res = root.val+"";
    	res += ","+serialize(root.left);
    	res += ","+serialize(root.right);
        return res;
    }

    private int index = 0;
    public TreeNode deserialize(String data) {
    	String[] arr = data.split(",");
    	index = 0;
    	TreeNode root = _deserialize(arr);
        return root;
    }
    
	private TreeNode _deserialize(String[] arr) {
		if(index >= arr.length || arr[index].equals("*")){
			index++;
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.valueOf(arr[index++]));
		root.left = _deserialize(arr);
		root.right = _deserialize(arr);
		return root;
	}




	public static void main(String[] args) {
		Codec c = new Codec();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left = t1;
//		t1.right = t3;
		t3.left=t2;
		t3.right = t4;
		String s = c.serialize(t3);
		System.out.println(s);
		
		TreeNode root = c.deserialize(s);
		System.out.println("ok");
	}

}