package p342;

public class V1 {
	public boolean isPowerOfFour(int num) {
		double d = Math.log10(num) / Math.log10(4);
		return d == (int)d;
	}
}
