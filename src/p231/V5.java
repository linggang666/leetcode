package p231;

public class V5 {
	public boolean isPowerOfTwo(int n) {
		double r = Math.log10(n) / Math.log10(2);
		return r == (int)r;
	}
}
