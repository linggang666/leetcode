package p065;

public class V1 {

	public boolean isNumber(String s) {
		s = s.trim();
		if (s.length() == 0)
			return false;
		String regexp = "^(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)(e(\\+|-)?[0-9]+)?$";
		return s.replaceAll(regexp, "").length() == 0;
	}

	public static void main(String[] args) {
		V1 v = new V1();
		System.err.println(v.isNumber(".e1"));
		System.err.println(v.isNumber("+.e"));
		System.err.println(v.isNumber(" 005047e+6"));
	}
}
