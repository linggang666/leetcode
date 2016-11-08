package p313;

import java.util.Arrays;

public class V1 {
	/**
	 * [3，5]
	 * [9,5]
	 * [8,15]
	 * [1,3,5,9,15,25]
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
	    int[] idx = new int[primes.length];

	    ugly[0] = 1;
	    for (int i = 1; i < n; i++) {
	        //find next
	        ugly[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < primes.length; j++)
	            ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
	        
	        //slip duplicate
	        for (int j = 0; j < primes.length; j++) {
	            while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
	        }
	    }
	    return ugly[n - 1];
	}
	
	
	public static void main(String[] args) {
		int[] a = {3,5};
		V1 v = new V1();
		System.out.println(v.nthSuperUglyNumber(7, a));
		System.out.println(v.nthSuperUglyNumber(8, a));
	}
}
