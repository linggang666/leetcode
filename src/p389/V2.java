package p389;


public class V2 {
	
	public char findTheDifference(String s, String t) {
		return (char) (getStrSum(t)-getStrSum(s));
	}
	
	private int getStrSum(String s){
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum;
	}
}
