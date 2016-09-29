package p231;

public class V4 {
	public boolean isPowerOfTwo(int n) {
		return Integer.toString(n, 2).matches("^10*$");
	}
}
