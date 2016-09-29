package p396;

public class V2 {
	
	/**
	 * @param A
	 * @return
	 */
	public int maxRotateFunction(int[] A) {
		if(A == null || A.length == 0) return 0;
		
		int len = A.length;
		int curFunSum = 0,sum = 0;;
		
		for (int i = 0; i < len; i++) {
			curFunSum += A[i] * i;
			sum += A[i];
		}
		
		int max = curFunSum;
		for (int i = 1; i < len; i++) {
			curFunSum = curFunSum + sum - A[len-i]*len;
			max = Math.max(curFunSum, max);
		}
		
		return max;
	}
}
