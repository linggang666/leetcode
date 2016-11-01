package p415;

public class V1 {
	
	public String addStrings(String num1, String num2) {
		char[] a1 = num1.toCharArray();
		char[] a2 = num2.toCharArray();
		int len1 = num1.length()-1, len2 = num2.length()-1;
		
		StringBuilder res = new StringBuilder();
		int step = 0;
		while(len1>=0 || len2>=0){
			if(len1 >= 0) step += a1[len1--] - '0';
			if(len2 >= 0) step += a2[len2--] - '0';
			res.insert(0, step%10);;
			step = step / 10;
		}
		
		if(step!=0){
			res.insert(0, 1);
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.addStrings("91", "12"));
	}
}
