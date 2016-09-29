package p204;

public class V2 {
	public int countPrimes(int n) {
		int count = 0;
		boolean[] f = new boolean[n];
		for (int i = 2; i < n; i++) {
			if(!f[i]){
				if(isPrimes(i)) {
					for (int j = 2; j*i < n; j++) {
						f[j*i] = true;
					}
					count++;
				}
			}
		}
		return count;
	}
	
	private boolean isPrimes(int i){
		if(i==2) return true;
		if(i==3) return true;
		if(i==5) return true;
		
		for (int k = 4; k*k <= i; k++) {
			if(i%k == 0) return false;
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println((new V2()).countPrimes(10));
		//System.out.println((new V2()).countPrimes(1500000));
	}
	
}
