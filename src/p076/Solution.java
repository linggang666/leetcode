package p076;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            cntMap.put(c, cntMap.getOrDefault(c, 0)-1);
        }
        
        char[] sArr = s.toCharArray();
        int leftPoint = 0, matchCnt=0;
        int lpos=-1, rpos=-1;
        for (int i = 0; i < sArr.length; i++) {
            if(cntMap.containsKey(sArr[i])) {
                cntMap.put(sArr[i], cntMap.get(sArr[i])+1);
                if(cntMap.get(sArr[i]) <= 0) {
                    matchCnt++;
                    if(matchCnt == t.length()) {
                        lpos = leftPoint;
                        rpos = i;
                        continue;
                    }
                }
            }
            while (leftPoint<=i && (!cntMap.containsKey(sArr[leftPoint]) || cntMap.get(sArr[leftPoint])>0)) {
                if(cntMap.containsKey(sArr[leftPoint])) {
                    cntMap.put(sArr[leftPoint], cntMap.get(sArr[leftPoint])-1);
                }
                leftPoint ++ ;
            }
            
            if(matchCnt==t.length() && i-leftPoint<rpos-lpos) {
                lpos = leftPoint;
                rpos = i;
            }
        }
        if(matchCnt < t.length()) {
            return "";
        }
        
        return s.substring(lpos, rpos+1);
    }
    
    
    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println("["+s.minWindow("ADOBECODEBANC", "ABCC")+"]");
    }

    //ADOBECODEBANC
    //ABC
}
