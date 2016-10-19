package p405;

public class V1 {
	
	
	public String toHex(int num) {
		if(num==0) return "0";
		
		char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		StringBuilder sb = new StringBuilder();
		while(num != 0){
			sb.insert(0, chars[num&0xf]);
			num = num>>>4;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.toHex(-1));
	}
}
