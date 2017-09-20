package p449;

import java.util.Arrays;

public class V1 {

    /**
     * Encodes a tree to a single string.
     */
    public String serialize(TreeNode root) {
        if(root == null){
            return "[null]";
        }
        StringBuilder res = new StringBuilder();
        res.append("[");
        res.append("["+root.val+"]");
        res.append("["+serialize(root.left)+"]");
        res.append("["+serialize(root.right)+"]");
        res.append("]");
        return res.toString();
    }

    /**
     * Decodes your encoded data to tree.
     */
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("[null]")){
            return null;
        }
        data = data.substring(1, data.length()-1);
        
        String[] split = new String[3];
        int splitIndex = 0;
        int leftCount = 1;
        int leftIndex = 0;
        for (int i = 1; i < data.length(); i++) {
            if(data.charAt(i) == '['){
                leftCount ++;
            }
            if(data.charAt(i) == ']'){
                leftCount --;
            }
            
            if(leftCount == 0){
                split[splitIndex++] = data.substring(leftIndex+1, i);
                leftIndex = i+1;
            }
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        root.left = this.deserialize(split[1]);
        root.right = this.deserialize(split[2]);
        
        return root;
    }

    public static void main(String[] args) {
        
        V1 v = new V1();
        
        String str = "[[1][[[3][[null]][[null]]]][[null]]]";
        v.deserialize(str);
        
//        
//        TreeNode root = new TreeNode(1);
//        TreeNode n1 = new TreeNode(3);
//        root.left = n1;
//        System.out.println(v.serialize(root));
    }

}
