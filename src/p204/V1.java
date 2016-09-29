package p204;

public class V1 {
	public int countPrimes(int n) {
		int count = 0;
		for (int i = 2; i < n; i++) {
			if(isPrimes(i)) count++;
		}
		
		return count;
	}
	
	private boolean isPrimes(int i){
		if(i%2 == 0 && i!=2) return false;
		if(i%3 == 0 && i!=3) return false;
		if(i%5 == 0 && i!=5) return false;
		
		for (int k = 7; k*k <= i; k++) {
			if(i%k == 0) return false;
		}
			
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println((new V1()).countPrimes(1500000));
	}
	
}
