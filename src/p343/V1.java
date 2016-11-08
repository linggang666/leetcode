package p343;

public class V1 {
	
	public int integerBreak(int n) {
		if(n==2) return 1;
		if(n==3) return 2;
		
		if(n%3 == 1){
			return (int) (4*Math.pow(3, (n-4)/3));
		}else if(n%3==2){
			return (int) (2*Math.pow(3, (n-2)/3));
		}
        return (int) Math.pow(3, n/3);
    }
}
