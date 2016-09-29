package p232;

public class Main {
	public static void main(String[] args) {
		V1 v = new V1();
		v.push(3);
		v.push(4);
		System.out.println(v.peek());
		v.pop();
		v.push(5);
		System.out.println(v.peek());
		v.pop();
		System.out.println(v.peek());
	}
}
