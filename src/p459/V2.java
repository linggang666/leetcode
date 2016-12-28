package p459;

import java.util.Arrays;

public class V2 {
	public boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		char[] strArr = str.toCharArray();
		int[] next = new int[len + 1];
		next[0] = -1;
		int j = 0, k = -1;
		
		while (j < len) {
			if (k == -1 || strArr[j] == strArr[k])
				next[++j] = ++k;
			else
				k = next[k];
		}
		return next[len] > 0 && next[len] % (len - next[len]) == 0;
	}

	public static void main(String[] args) {
		V2 v = new V2();
		System.out.println(v.repeatedSubstringPattern("abcabcabc"));
	}
}
