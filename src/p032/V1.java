package p032;


public class V1 {

	public int longestValidParentheses(String s) {
		char[] S = s.toCharArray();
		int[] V = new int[S.length];
		int open = 0;
		int max = 0;
		for (int i = 0; i < S.length; i++) {
			if (S[i] == '(') open++;
			if (S[i] == ')' && open > 0) {
				V[i] = 2 + V[i - 1] + (i-2-V[i-1]>0?V[i-2-V[i-1]] : 0);
				open--;
			}
			if (V[i] > max) max = V[i];
		}
		return max;
	}

	public static void main(String[] args) {
		V1 v = new V1();
		//System.out.println(v.longestValidParentheses(")(((((()())()()))()(()))("));
		System.out.println(v.longestValidParentheses(")()(())"));
		//System.out.println(v.longestValidParentheses(")()"));
	}
}
