package p006;

public class Main {
	public static void main(String[] args){
		System.out.println((new V2()).convert("PAYPALISHIRING", 3));
		System.out.println((new V2()).convert("A", 2));
		System.out.println((new V2()).convert("ABC", 2));
		System.out.println((new V2()).convert("ABCD", 2));
		System.out.println((new V2()).convert("PAYPALISHIRING", 2));
		System.out.println((new V2()).convert("abcdefghigklmnopqrstuvwxyz", 4));
	}
}
