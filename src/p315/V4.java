package p315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V4 {
	
	
	private void sort(int[] nums, int[] pos, int from, int to) {  
        if (from>=to) return;  
        int m = (from+to)/2;  
        sort(nums, pos, from, m);  
        sort(nums, pos, m+1, to);  
        int[] merged = new int[to-from+1];  
        int i=from, j=m+1, p=0;  
        while (i<=m || j<=to) {  
            if (i>m) {  
                merged[p++] = pos[j++];  
            } else if (j>to) {  
                merged[p++] = pos[i++];  
            } else if (nums[pos[i]] <= nums[pos[j]]) {  
                merged[p++] = pos[i++];  
            } else {  
                merged[p++] = pos[j++];  
            }  
        }  
        for(int k=0; k<merged.length; k++) pos[from+k] = merged[k];  
    }  
    private int count(int[] sum, int s) {  
        int count = 0;  
        while (s>0) {  
            count += sum[s];  
            s -= (s & -s);  
        }  
        return count;  
    }  
    private void update(int[] sum, int s) {  
        while (s<sum.length) {  
            sum[s] ++;  
            s += (s & -s);  
        }  
    }  
    
    /**
     * 树状数组  ~~
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {  
        int[] pos = new int[nums.length];  
        for(int i=0; i<nums.length; i++) pos[i] = i;  
        sort(nums, pos, 0, nums.length-1);  
        int[] seq = new int[nums.length];  
        for(int i=0, s=0; i<pos.length; i++) {  
            if (i==0 || nums[pos[i]] != nums[pos[i-1]]) seq[pos[i]] = ++ s; else seq[pos[i]] = s;  
        }  
        int[] sum = new int[nums.length+1];  
        int[] smaller = new int[nums.length];  
        for(int i=nums.length-1; i>=0; i--) {  
            smaller[i] = count(sum, seq[i]-1);  
            update(sum, seq[i]);  
        }  
        List<Integer> result = new ArrayList<>(nums.length);  
        for(int i=0; i<smaller.length; i++) result.add(smaller[i]);  
        return result;  
    }   


	public static void main(String[] args) {
		int[] a = { 5, 2, 6, 1 ,0};
		V4 v = new V4();
		System.out.println(Arrays.toString(v.countSmaller(a).toArray()));
	}
}
