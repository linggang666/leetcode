package p151;

public class V1 {
	public String reverseWords(String s) {
		s = s.trim();
		if(s.length() == 0) return "";
		
		String[] arr = s.split(" +");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length-1; i >= 0; i--) {
			sb.append(arr[i]).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.reverseWords("ab cd    eff dd  "));
	}
}
