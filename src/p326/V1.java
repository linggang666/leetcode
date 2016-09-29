package p326;

public class V1 {
	public boolean isPowerOfThree(int n) {
		int i = 0;
		double tmp=0;
		while(tmp <= n){
			tmp = Math.pow(3, i);
			if(tmp == n) return true;
			i++;
		}
		return false;
	}
}
