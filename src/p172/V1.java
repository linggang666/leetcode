package p172;

public class V1 {
	public int trailingZeroes(int n) {
		if (n / 5 < 5) {
	        return n / 5;
	    } else {
	        return n /5 + trailingZeroes(n / 5);
	    }
    }
}
