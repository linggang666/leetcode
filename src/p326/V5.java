package p326;

public class V5 {
	public boolean isPowerOfThree(int n) {
		double r = Math.log10(n) / Math.log10(3);
		return r == (int)r;
	}
}
