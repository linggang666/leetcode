package p028;

public class V2 {
	/**
	 * foce
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		for (int index = 0, subIndex = 0; index < haystack.length() && subIndex < needle.length(); index++) {
			if (haystack.charAt(index) == needle.charAt(subIndex)) {
				if (subIndex == needle.length() - 1)
					return index - needle.length() + 1;
				subIndex++;
			} else {
				index -= subIndex;
				subIndex = 0;
			}
		}
		return needle.length() == 0 ? 0 : -1;
	}
}
