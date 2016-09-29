package p396;

public class V1 {
	
	/**
	 * 	 Time Limit Exceeded
	 * @param A
	 * @return
	 */
	public int maxRotateFunction(int[] A) {
		if(A == null || A.length == 0) return 0;
		int len = A.length;
		int startIndex = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < len; i++) {
			int t = 0;
			startIndex = (len - i) % len;
			for (int j = 1; j < len; j++) {
				t += j * A[(startIndex+j)%len];
			}
			max = Math.max(t, max);
		}
		
		return max;
	}
}
