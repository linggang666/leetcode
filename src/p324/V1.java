package p324;

import java.util.Arrays;

public class V1 {

	public void wiggleSort(int[] nums) {
		if(nums.length<2) return;  
		Arrays.sort(nums);
        int len = nums.length;
        int mid=nums[len/2];  
        
        int[] ans = new int[len];
        for (int i = 0; i < len; i++)
        	ans[i] = mid;
        
        int index = 1;
        for(int i = len-1; i >=0 && nums[i]>mid; i--, index+=2)  
            ans[index] = nums[i]; 
        
        index = (len%2==1)?len-1:len-2;
        for(int i = 0; i<len && nums[i]<mid; i++, index-=2)  
            ans[index] = nums[i];  
        
        for (int i = 0; i < len; i++) {
			nums[i] = ans[i];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1, 1, 1, 2, 2, 3};
		V1 v = new V1();
		v.wiggleSort(a);
		System.out.println(Arrays.toString(a));
	}
}
