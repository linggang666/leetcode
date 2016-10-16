package p301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

	List<String> res = new ArrayList<>();

	public List<String> removeInvalidParentheses(String s) {
		DFS(s, ')', 0);
		return res;
	}

	private void DFS(String s, char ch, int last) {
		for (int i = 0, cnt = 0; i < s.length(); i++) {
			char curChar = s.charAt(i);
			if (curChar == '(' || curChar == ')')
				if (curChar == ch)
					cnt++;
				else
					cnt--;
			if (cnt <= 0) continue;
			for (int j = last; j <= i; j++) {
				if (s.charAt(j) == ch && (j == last || s.charAt(j - 1) != ch))
					DFS(s.substring(0, j) + s.substring(j + 1), ch, j);
			}
			return;
		}
		s = (new StringBuilder(s)).reverse().toString();
		if (ch == ')') {
			DFS(s, '(', 0);
			return;
		}
		res.add(s);
	}

	public static void main(String[] args) {
		String string = "()())(()";
		V1 v = new V1();
		System.out.println(Arrays.toString(v.removeInvalidParentheses(string)
				.toArray()));
	}
}
