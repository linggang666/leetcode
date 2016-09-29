package p045;

import java.util.Arrays;

public class V2 {
	
	
	public int jump(int[] nums) {
		int jumps = 0;
		int rPos = 0, lPos=0;
		while(rPos < nums.length-1){
			jumps++;
			int temp = rPos;
			for (int i = rPos; i >= lPos; i--) {
				if(i+nums[i] > rPos) {
					rPos= i+nums[i];
					if(rPos >= nums.length-1) 
						break;
				}
			}
			lPos = temp+1;
		}
		
		return jumps;
	}
	
	

	public static void main(String[] args) {
		int[] a = {1,0};
		
		int[] arr = new int[25002];
		for (int i = 0; i < 25000; i++) {
			arr[i] = 25000-i;
		}
		arr[25000] = 1;
		arr[25001] = 0;
		System.out.println(Arrays.toString(arr));
		V2 v = new V2();
		System.out.println(v.jump(a));

	}

}
