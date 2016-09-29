package p204;

public class V3 {
	public int countPrimes(int n) {
		int count = 0;
		boolean[] f = new boolean[n];
		for (int i = 2; i < n; i++) {
			if(!f[i]){
				for (int j = 2; j*i < n; j++) {
					f[j*i] = true;
				}
				count++;
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		System.out.println((new V3()).countPrimes(10));
		System.out.println((new V2()).countPrimes(15000010));
	}
	
}
