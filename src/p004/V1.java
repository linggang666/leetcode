package p004;

public class V1 {

	public double findMedianSortedArrays(int[] A, int[] B) {
		int lenA = A.length, lenB = B.length;
		double res = getKth(A,0,lenA-1, B, 0, lenB-1, (lenA+lenB-1)/2);
		if((lenA+lenB)%2==0){
			double k2 = getKth(A,0,lenA-1, B, 0, lenB-1, (lenA+lenB)/2);
			res = (res+k2)/2.0;
		}
		return res;
	}


	public double getKth(int[] a, int al, int ar, int[] b, int bl, int br, int k) {
		if(al>ar) return b[bl+k];
		if(bl>br) return a[al+k];
		int am = al+(ar-al)/2;
		int bm = bl+(br-bl)/2;
		
		if(a[am]<=b[bm]){
			if(k<=am-al+bm-bl){
				return getKth(a, al, ar, b, bl, bm-1, k);
			}else{
				return getKth(a, am+1, ar, b, bl, br, k-(am-al)-1);
			}
		}else{
			if(k<=am-al+bm-bl){
				return getKth(a, al, am-1, b, bl, br, k);
			}else{
				return getKth(a, al, ar, b, bm+1, br, k-(bm-bl)-1);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 5 };
		int[] b = { 3, 5, 6 ,9,12};
		V1 v = new V1();
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 0));
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 1));
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 2));
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 3));
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 4));
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 5));
//		System.out.println(v.getKth(a, 0, a.length-1, b, 0, b.length-1, 6));
		System.out.println(v.findMedianSortedArrays(a, b));
	}
}
