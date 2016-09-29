package p371;

public class V1 {
	public int getSum(int a, int b) {
		if (a == 0)
			return b;
		else
			return getSum((a & b) << 1, a ^ b);
	}
}
