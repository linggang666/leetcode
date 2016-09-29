package p258;

public class V1 {
	public int addDigits(int num) {
		int result = num;
		while(result >= 10){
			int t = result;
			result = 0;
			while(t>=10){
				result += t%10;
				t = t/10;
			}
			result += t;
		}
		return result;
	}
}
