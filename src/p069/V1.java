package p069;

public class V1 {
	public int mySqrt(int x) {
		double r1=x/2, r2=0;
		while((int)r1!=(int)r2){
			System.out.println(r1 + "    "+r2);
			r2 = r1;
			r1 = (r1 + x/r1)/2;
		}
		return (int) r1;
	}

	
	public static void main(String[] args) {
		V1 v = new V1();
		double s = Math.sqrt(12);
		System.out.println(v.mySqrt(5));
	}
}
