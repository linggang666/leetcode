package p389;


public class V3 {
	public char findTheDifference(String s, String t) {
		int r = 0;
		String u = s+t;
		for (int i = 0; i < u.length(); i++) {
			r ^= u.charAt(i);
		}
		return (char) r;
	}
}
