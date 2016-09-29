package p001;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] nums = {0,4,3,0};
		//int[] nums = {0,4,4,0};
		//int[] nums = {-3,4,3,90};
		
		int[] indices = (new V4()).twoSum(nums, 0);
		if(indices != null){
			System.out.println(Arrays.toString(indices));
		}else{
			System.out.println("no resule");
		}
	}
}
