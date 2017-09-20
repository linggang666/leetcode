package p424;

import java.util.Arrays;

public class V1 {
    
    public int characterReplacement(String s, int k) {
        if(s == null || s.length()==0){
            return 0;
        }
        
        int len = s.length();
        int[] flag = new int[k];
        int max = 0;
        for (int i = 0; i < 26; i++) {
            char c = (char)('A' + i);
            Arrays.fill(flag, -1);
            int left = 0, flagIndex = 0;
            for (int j = 0; j < len; j++) {
                if(s.charAt(j) != c){
                    if(k > 0){
                        if(flag[flagIndex] != -1){
                            left = flag[flagIndex] + 1;
                        }
                        flag[flagIndex] = j;
                        flagIndex++;
                        if(flagIndex == k){
                            flagIndex = 0;
                        }
                    }else{
                        left = j + 1;
                    }
                }
                max = Math.max(max, j-left+1);
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.characterReplacement("AAAA", 0));
    }
}
