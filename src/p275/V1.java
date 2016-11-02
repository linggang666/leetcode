package p275;

public class V1 {
	public int hIndex(int[] citations) {
		int len = citations.length;
		
		int l=0, r=len-1;
		while(l<r){
			int m = l+(r-l)/2;
			if(citations[m] >= len-m){
				r=m-1;
			}else{
				l=m+1;
			}
		}
		if(r<0)
			return len;
		else if(citations[r] >= len-r)
			return len-r;
		else
			return len-r -1;
	}
	
	public static void main(String[] args) {
		int[] a = {};
		V1 v = new V1();
		System.out.println(v.hIndex(a));
	}
}
