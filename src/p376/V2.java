package p376;

public class V2 {

	public int wiggleMaxLength(int[] nums) {
		if(nums.length < 2) return nums.length;  
        int len = nums.length;  
        int ans = 1, flag = 0;  
        for(int i = 1; i < len; i++) {  
        	if(nums[i] > nums[i-1] && flag !=1){
        		ans ++;
        		flag = 1;
        	}else if(nums[i] < nums[i-1] && flag !=-1){
        		ans ++;
        		flag = -1;
        	}
        }  
        return ans;   
	}

	public static void main(String[] args) {
		int[] a = {1,17,5,10,130,15,10,5,16,8};
		int[] b = {2,3,3,3,2,5};
		V2 v = new V2();
		System.out.println(v.wiggleMaxLength(a));
		System.out.println(v.wiggleMaxLength(b));
	}

}
