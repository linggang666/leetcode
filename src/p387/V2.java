package p387;

public class V2 {
	public int firstUniqChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (s.lastIndexOf(s.charAt(i)) == s.indexOf(s.charAt(i)))
				return i;
		}
		return -1;
	}
}
