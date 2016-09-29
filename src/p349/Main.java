package p349;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

		int[] a1 = new int[]{1,2,7};
		int[] a2 = new int[]{1,2,3,4,2};
		System.out.println(Arrays.toString((new V1()).intersection(a1, a2)));
	}
}
