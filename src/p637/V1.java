package p637;

import java.util.ArrayList;
import java.util.List;

public class V1 {
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double[]> stat = new ArrayList<>();
        traverse(root, stat,  0);
        
        List<Double> res = new ArrayList<>();
        for(Double[] arr: stat){
            res.add(arr[0]/arr[1]);
        }
        return res;
    }

    private void traverse(TreeNode root, List<Double[]> stat, int i) {
        if(root == null){
            return;
        }
        if(stat.size() == i){
            stat.add(new Double[]{0.0, 0.0});
        }
        Double[] t = stat.get(i);
        t[0] += root.val;
        t[1] ++;
        
        traverse(root.left, stat, i+1);
        traverse(root.right, stat, i+1);
    }
}
