package p167;

import java.util.Arrays;

public class V1 {
	public int[] twoSum(int[] numbers, int target) {
		
		int len = numbers.length;
		for (int i = 0; i < len; i++) {
			int secondIndex = findIndex(numbers, i+1, len-1, target-numbers[i]);
			if(secondIndex != -1){
				return new int[]{i+1,secondIndex+1};
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	private int findIndex(int[] numbers,int l, int r, int n) {
		if(l > r) return -1;
		int mid = l + (r-l)/2;
		if(numbers[mid] == n){
			return mid;
		}else if(numbers[mid] > n){
			return findIndex(numbers, l, mid-1, n);
		}else{
			return findIndex(numbers, mid+1, r, n);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,4,5,7,8};
		System.out.println(Arrays.toString((new V1()).twoSum(a, 11)));
	}
}
