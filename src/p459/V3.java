package p459;

import java.util.Arrays;

public class V3 {
	public boolean repeatedSubstringPattern(String str) {
		int len = str.length();
		char[] arr = str.toCharArray();
		int[] next = new int[len+1];
		int j=0;
		
		for (int i = 1; i < len; i++) {
			while(j>0 && arr[j] != arr[i])
				j = next[j];
			if(arr[i] == arr[j])
				j++;
			next[i+1] = j;
		}
		return next[len]>0 && next[len]%(len-next[len])==0;
	}

	public static void main(String[] args) {
		V3 v = new V3();
		System.out.println(v.repeatedSubstringPattern("abcabcabc"));
	}
}
