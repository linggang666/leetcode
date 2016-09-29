package p274;

import java.util.Arrays;

public class V1 {
	
	public int hIndex(int[] citations) {
		int res = 0;
		Arrays.sort(citations);
		for (int i = citations.length-1; i >=0; i--) {
			if(citations[i] > res){
				res++;
			}else{
				break;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		V1 v = new V1();
		int[] a = {4, 0, 6, 1, 5};
		System.out.println(v.hIndex(a));
	}
}
