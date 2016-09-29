package p283;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[]{2,4,0,5,1,0,6};
		(new V2()).moveZeroes(arr);
		System.out.println(Arrays.toString(arr));

	}

}
