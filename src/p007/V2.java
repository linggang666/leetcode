package p007;

public class V2 {
	public int reverse(int x) {
		int x1 = Math.abs(x);
		long result = 0;
		boolean isN = x<0;
		while(x1 > 0){
			result = result*10+(x1%10);
			x1 = x1 / 10;
		}
		if((isN && -result < Integer.MIN_VALUE) || result > Integer.MAX_VALUE){
			return 0;
		}
		
		return (int) (isN ? -result: result);
	}
}
