package p027;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] a = {3,0,2,0,2,3};
		System.out.println((new V2()).removeElement(a, 3));
		System.out.println(Arrays.toString(a));
	}

}
