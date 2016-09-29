package p231;

public class V1 {
	public boolean isPowerOfTwo(int n) {
		int i = 0;
		double tmp=0;
		while(tmp <= n){
			tmp = Math.pow(2, i);
			if(tmp == n) return true;
			i++;
		}
		return false;
	}
}
