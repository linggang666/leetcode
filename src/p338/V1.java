package p338;

import java.util.Arrays;

public class V1 {

	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			result[i] = getBitCount(i);
		}
		return result;
	}

	private int getBitCount(int i) {
		int count = 0;
		while (i != 0) {
			if ((i & 1) == 1) {
				count++;
			}
			i = i >>> 1;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString((new V1()).countBits(16)));
	}

}
