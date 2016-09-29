package p384;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Solution {

	int[] nums;
	public Solution(int[] nums) {
		this.nums = nums;
	}

	public int[] reset() {
		return this.nums;
	}

	public int[] shuffle() {
		List<Integer> list = new ArrayList<>();
		for (Integer integer : this.nums) {
			list.add(integer);
		}
		
		int len = this.nums.length;
		int[] result = new int[len];
		Random r = new Random();
		for (int i = 0; i < len; i++) {
			int ri = r.nextInt(len-i);
			result[i] = list.get(ri);
			list.remove(ri);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		Solution s = new Solution(a);
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println(Arrays.toString(s.reset()));
	}

}
