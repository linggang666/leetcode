package p048;

import java.util.Arrays;

public class V1 {
	
	/**
	 * in-place
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int len = matrix.length;
		for (int i = 0; i < len/2; i++) {
			int len1 = len-i*2+i-1;
			for (int j = i; j < len1; j++) {
				System.out.println(i+"  "+j);
				int t = matrix[i][j];
				matrix[i][j] = matrix[len-j-1][i];
				matrix[len-j-1][i] = matrix[len-i-1][len-j-1];
				matrix[len-i-1][len-j-1] = matrix[j][len-i-1];
				matrix[j][len-i-1] = t;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] a = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		int[][] b = {
				{1,2,3},
				{5,6,7},
				{9,10,11}
		};
		V1 v = new V1();
		v.rotate(b);
		for (int i = 0; i < b.length; i++) {
			System.out.println(Arrays.toString(b[i]));
		}
	}
}
