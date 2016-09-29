package p326;

public class Main {
	public static void main(String[] args){
		System.out.println((new V5()).isPowerOfThree(0));
		System.out.println((new V5()).isPowerOfThree(1));
		System.out.println((new V5()).isPowerOfThree(81));
		System.out.println((new V5()).isPowerOfThree(15));
		
		System.out.println(Integer.toString(81, 3));
	}
}
