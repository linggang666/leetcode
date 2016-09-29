package p058;

public class V1 {
	public int lengthOfLastWord(String s) {
		if(s == null || s.trim().length()==0) return 0;
		String[] arr = s.trim().split(" ");
		return arr[arr.length-1].length();
	}
}
