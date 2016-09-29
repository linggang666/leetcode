package p167;

import java.util.Arrays;

public class V2 {
	public int[] twoSum(int[] numbers, int target) {
		
		int l=0, r=numbers.length-1;
		while(l<r){
			int sum = numbers[l] + numbers[r];
			if(sum == target){
				return new int[]{l+1,r+1};
			}else if(sum>target){
				r--;
			}else{
				l++;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int[] a = {2,3,4,5,7,8};
		System.out.println(Arrays.toString((new V2()).twoSum(a, 11)));
	}
}
