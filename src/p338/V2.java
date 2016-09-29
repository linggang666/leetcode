package p338;

import java.util.Arrays;

public class V2 {

	public int[] countBits(int num) {
		int[] result = new int[num+1];
		int range=1,t=0;
		for (int i = 1; i <= num; i++) {
			result[i] = result[i-range+t++] + 1;
			if(t==range){
				range <<= 1;
				t = 0;
			}
		}
		return result;
	}
	

	public static void main(String[] args) {
		System.out.println(Arrays.toString((new V2()).countBits(16)));
	}

}
