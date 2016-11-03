package p319;

public class V1 {
	
	public int bulbSwitch(int n) {
		return (int)Math.sqrt(n);
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.bulbSwitch(3));
	}
}
