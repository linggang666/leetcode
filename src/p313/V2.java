package p313;

import java.util.Arrays;

public class V2 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] ugly = new int[n];
        int[] idx = new int[primes.length];
        int[] val = new int[primes.length];
        Arrays.fill(val, 1);

        int next = 1;
        for (int i = 0; i < n; i++) {
            ugly[i] = next;
            
            next = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                //skip duplicate and avoid extra multiplication
                if (val[j] == ugly[i]) val[j] = ugly[idx[j]++] * primes[j];
                //find next ugly number
                next = Math.min(next, val[j]);
            }
        }
        return ugly[n - 1];
	}
	
	
	public static void main(String[] args) {
		int[] a = {3,5};
		V2 v = new V2();
		System.out.println(v.nthSuperUglyNumber(7, a));
		System.out.println(v.nthSuperUglyNumber(8, a));
	}
}
