package p168;

public class V1 {
	public String convertToTitle(int n) {

		String result = "";
		while (n != 0) {
			char c = (char) (--n % 26 + 'A');
			result = c + result;
			n = n / 26;
		}
		return result;
	}
}
