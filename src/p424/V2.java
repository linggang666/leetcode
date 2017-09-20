package p424;

public class V2 {
    
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        V2 v = new V2();
        System.out.println(v.characterReplacement("AAAAAACABASSSFFDDFFFFSA", 1));
    }
    
}
