package p008;

public class Main {

	/**
	 * 32w3=>32
	 * Integer.MAX_VALUE Integer.Min_VALUE
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(((new V1()).myAtoi("234")));
		System.out.println(((new V1()).myAtoi("-0232www")));
		System.out.println(((new V1()).myAtoi("    010")));
		System.out.println(((new V1()).myAtoi("wwe")));
		System.out.println(0+'4'-48);
	}

}
