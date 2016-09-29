package p005;

public class Main {

	public static void main(String[] args) {
		System.out.println((new V1()).longestPalindrome(""));
		System.out.println((new V1()).longestPalindrome("d"));
		System.out.println((new V1()).longestPalindrome("1234344"));
		System.out.println((new V1()).longestPalindrome("1111111"));
		System.out.println((new V1()).longestPalindrome("bb"));
	}
}
