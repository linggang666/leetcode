package p228;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList();
		if(nums==null || nums.length==0) return result;
		
		int left=nums[0],right=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]-1==right){
				right++;
			}else{
				if(left == right){
					result.add(""+left);
				}else{
					result.add(left+"->"+right);
				}
				left = nums[i];
				right = nums[i];
			}
		}
		
		if(left == right){
			result.add(""+left);
		}else{
			result.add(left+"->"+right);
		}

		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,5,7,8,9,11};
		V1 v = new V1();
		
		System.out.println(Arrays.toString(v.summaryRanges(a).toArray()));
	}
}
