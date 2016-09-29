package p376;

import java.util.Arrays;

public class V1 {

	/**
	 * error dp
	 * @param nums
	 * 
	 * if(nums[i]-nums[j])*(nums[j]-nums[j-1] <0) dp[i] = max(dp[i], dp[j]+1);
		else dp[i] = max(dp[i], dp[j]);
	 * @return
	 */
	public int wiggleMaxLength(int[] nums) {
		if(nums.length < 2) return nums.length;  
        int len = nums.length;  
        int[] dp = new int[len];  
        
        dp[0] = 1;
        dp[1] = nums[0]==nums[1]?1:2;
        for(int i = 2; i < len; i++) {  
            for(int j = 1; j < i; j++)  { 
            	int t = ((nums[i]-nums[i-1])*(nums[i-1]-nums[i-2])<0)? 1:0;
                dp[i] = Math.max(dp[i], dp[j] + t);  
            }  
        }  
//        for(int i = 1; i < len; i++){  
//        	if(dp[i-1]==1){
//        		dp[i] = nums[i]==nums[i-1]?1:2;
//        	}else{
//        		int t = ((nums[i]-nums[i-1])*(nums[i-1]-nums[i-2])<0)? 1:0;
//        		dp[i] = dp[i-1]+t;  
//        	}
//        }  
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
        return dp[len-1];  
	}

	public static void main(String[] args) {
		int[] a = {1,17,5,10,130,15,10,5,16,8};
		int[] b = {2,3,3,3,2,5};
		V1 v = new V1();
		System.out.println(v.wiggleMaxLength(a));
		System.out.println(v.wiggleMaxLength(b));
	}

}
