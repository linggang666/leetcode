package p318;

public class V1 {
	public int maxProduct(String[] words) {
		if(words == null || words.length<2) return 0;
		int[] bits = new int[words.length]; 
		for (int i = 0; i < bits.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				bits[i] |= 1<<words[i].charAt(j)-'a';
			}
		}
		
		int result = 0;
		for (int i = 0; i < bits.length; i++) {
			for (int j = i+1; j < bits.length; j++) {
				if((bits[i] & bits[j]) == 0){
					result = Math.max(result, words[i].length()*words[j].length());
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] arr = {"abd", "abdd", "ce"};
		V1 v = new V1();
		System.out.println(v.maxProduct(arr));
	}
}
