package p020;

import java.util.Stack;

public class V1 {
	public boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<>();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if(c == '}' && (stack.empty() || stack.pop()!='{')) return false;
			if(c == ']' && (stack.empty() || stack.pop()!='[')) return false;
			if(c == ')' && (stack.empty() || stack.pop()!='(')) return false;
			if(c == '{' || c=='[' || c=='(') stack.push(c);
		}
		return stack.empty();
	}
}
