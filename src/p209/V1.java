package p209;

public class V1 {
	public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int l=0,r=0;
        int curSum = 0;
        while(r<nums.length){
        	if(nums[r]>=s) return 1;
        	curSum += nums[r];
        	if(curSum>=s){
        		while(curSum >= s){
        			curSum-=nums[l++];
        		}
        		minLen = Math.min(minLen, r-l+2);
        	}
        	r++;
        }
        return minLen==Integer.MAX_VALUE?0:minLen;
    }
	
	public static void main(String[] args) {
		int[] a = {7,2,1,2,3,3};
		V1 v = new V1();
		System.out.println(v.minSubArrayLen(7, a));
	}
}
