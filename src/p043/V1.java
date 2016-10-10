package p043;

public class V1 {
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";

		int[] n1 = this.getIntArr(num1);
		int[] n2 = this.getIntArr(num2);
		int[] result = new int[num1.length()+num2.length()];
		
		for (int i = n1.length-1; i >=0; i--) {
			for (int j = n2.length-1; j >=0; j--) {
				int t = n1[i] * n2[j];
				t += result[i+j+1];
				result[i+j+1] = t%10;
				result[i+j] += t/10;
			}
		}
		
		int i = result[0] == 0? 1 : 0;
		String str = "";
		for ( ;i<result.length;i++) {
			str += result[i];
		}
		
		return str;
	}
	
	private int[] getIntArr(String num){
		int[] n = new int[num.length()];
		for (int i = 0; i < n.length; i++) {
			n[i] = num.charAt(i)-'0';
		}
		return n;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.multiply("13", "8"));
	}
}
