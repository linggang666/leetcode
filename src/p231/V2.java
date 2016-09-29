package p231;

public class V2 {
	public boolean isPowerOfTwo(int n) {
		while(n>0 && n%2 == 0){
			n = n/2;
		}
		return n==1;
	}
}
