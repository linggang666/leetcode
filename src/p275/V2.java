package p275;

public class V2 {
	public int hIndex(int[] citations) {
		int len = citations.length;
		
		int l=0, r=len-1;
		while(l<=r){
			int m = l+(r-l)/2;
			if(citations[m] == len-m) 
				return len-m;
			else if(citations[m] > len-m){
				r=m-1;
			}else{
				l=m+1;
			}
		}
		return len-l;
	}
	
	public static void main(String[] args) {
		int[] a = {0};
		V2 v = new V2();
		System.out.println(v.hIndex(a));
	}
}
