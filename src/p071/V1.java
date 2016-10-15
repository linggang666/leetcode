package p071;

import java.util.Stack;

public class V1 {
	public String simplifyPath(String path) {

		String[] arr = path.split("/+");
		Stack<String> stack = new Stack<>();
		for (String s : arr) {
			switch (s) {
			case "":
				break;
			case ".":
				break;
			case "..":
				if (!stack.empty())
					stack.pop();
				break;
			default:
				stack.push(s);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.empty()) {
			sb.insert(0, stack.pop()).insert(0, "/");
		}
		return sb.length()==0?"/":sb.toString();
	}

	public static void main(String[] args) {
		V1 v1 = new V1();
		System.out.println(v1.simplifyPath("/"));
	}
}
