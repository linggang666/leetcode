package p567;

import java.util.Arrays;

public class V1 {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Cnt = new int[26];
        int[] s2Cnt = new int[26];
        for(char c : s1.toCharArray()){
            s1Cnt[c-'a']++;
        }
        
        int s1Len = s1.length();
        for (int i = 0; i < s2.length()-s1Len+1; i++) {
            if(i == 0){
                for(char c : s2.substring(0, s1.length()).toCharArray()){
                    s2Cnt[c-'a']++;
                }
            }else{
                s2Cnt[s2.charAt(i-1)-'a']--;
                s2Cnt[s2.charAt(i+s1Len-1)-'a']++;
            }
            if(Arrays.equals(s1Cnt, s2Cnt)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        V1 c = new V1();
        System.out.println(c.checkInclusion("aoboo", "eidbaooo"));
    }
}
