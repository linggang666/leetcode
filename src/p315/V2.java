package p315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V2 {
	
	/**
	 * 二叉搜索树  ~~
	 * @param nums
	 * @return
	 */
    public List<Integer> countSmaller(int[] nums) {  
        int[] tree = Arrays.copyOf(nums, nums.length);  
        Arrays.sort(tree);  
        int[] smaller = new int[nums.length];  
        int[] count = new int[nums.length];  
        for(int i=nums.length-1; i>=0; i--) {  
            count[i] = smaller(tree, smaller, nums[i]);  
            update(tree, smaller, nums[i]);  
        }  
        List<Integer> results = new ArrayList<>(nums.length);  
        for(int i=0; i<count.length; i++) results.add(count[i]);  
        return results;  
    } 
    
	private void update(int[] tree, int[] smaller, int value) {  
        int i=0, j=tree.length-1;  
        while (i<=j) {  
            int m = (i+j)/2;  
            if (value < tree[m]) {  
                smaller[m] ++;  
                j = m - 1;  
            } else {  
                i = m + 1;  
            }  
        }  
    }  
	
    private int smaller(int[] tree, int[] smaller, int value) {  
        int sum = 0;  
        int i=0, j=tree.length-1;  
        while (i<=j) {  
            int m = (i+j)/2;  
            if (tree[m] <= value) {  
                sum += smaller[m];  
                i = m + 1;  
            } else {  
                j = m - 1;  
            }  
        }  
        return sum;  
    }  

	public static void main(String[] args) {
		int[] a = { 5, 2, 6, 1 ,0};
		V2 v = new V2();
		System.out.println(Arrays.toString(v.countSmaller(a).toArray()));
	}
}
