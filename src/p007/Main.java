package p007;

public class Main {

	public static void main(String[] args) {
		//System.out.println(Integer.MAX_VALUE);
		System.out.println((new V3()).reverse(-2147483648));
		System.out.println((new V3()).reverse(-2143847412));
		System.out.println((new V3()).reverse(1534236469));
		System.out.println((new V3()).reverse(123));
		System.out.println((new V3()).reverse(123));
	}

}
