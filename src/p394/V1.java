package p394;

import java.util.Stack;

public class V1 {
	
	public String decodeString(String s) {
        if(s==null || s.length()<4) return s;
        
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
			if(arr[i] != ']'){
				stack.push(arr[i]);
			}else{
				StringBuilder sb = new StringBuilder();
				while (stack.peek() != '[') {
					sb.insert(0, stack.pop());
				}
				String subString = sb.toString();
				sb.delete(0, sb.length());
				stack.pop();
				while(!stack.empty() && Character.isDigit(stack.peek())){
					sb.insert(0, stack.pop());
				}
				int cnt = Integer.valueOf(sb.toString());
				sb.delete(0, sb.length());
				while (cnt-->0) {
					sb.append(subString);
				}
				for (int j = 0; j < sb.length(); j++) {
					stack.push(sb.charAt(j));
				}
			}
		}
        StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.decodeString("3[a]2[bc]"));
		System.out.println(v.decodeString("3[a2[c]]"));
		System.out.println(v.decodeString("2[abc]3[cd]ef"));
	}
}
