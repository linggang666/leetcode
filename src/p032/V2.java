package p032;

import java.util.Stack;

public class V2 {

	public int longestValidParentheses(String s) {
		int n = s.length(), longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.empty()) {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
	}

	public static void main(String[] args) {
		V2 v = new V2();
		System.out.println(v
				.longestValidParentheses(")(((((()())()()))()(()))("));
		System.out.println(v.longestValidParentheses(")()())"));
		System.out.println(v.longestValidParentheses(")()"));
	}
}
