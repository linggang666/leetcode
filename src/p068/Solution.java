package p068;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int len = words.length;
        if(len == 0) {
            return res;
        }
        
        int curWidth=0, startIndex=0;
        for (int i = 0; i < len; i++) {
            if(curWidth + words[i].length() <= maxWidth) {
                curWidth = curWidth+words[i].length()+1;
            }else {
                res.add(this.buildString(words, maxWidth, startIndex, i-1));
                curWidth = words[i].length()+1;
                startIndex = i;
            }
        }
        if(startIndex != len) {
            res.add(this.buildString(words, maxWidth, startIndex, len-1));
        }
        return res;
    }
    
    private String buildString(String[] words, int maxWidth, int left, int right) {
        StringBuilder res = new StringBuilder();
        
        int spaceWidth = maxWidth;
        if(left==right || right==words.length-1) {
            while(left <= right) {
                res.append(words[left]);
                spaceWidth = spaceWidth - words[left].length();
                if(spaceWidth>0) {
                    res.append(" ");
                    spaceWidth--;
                }
                left++;
            }
            while (spaceWidth-->0) {
                res.append(" ");
            }
        }else {
            for (int i = left; i <= right; i++) {
                spaceWidth -= words[i].length();
            }
            while(left < right) {
                res.append(words[left]);
                
                int t=spaceWidth/(right-left);
                if(spaceWidth%(right-left)>0) t++;
                spaceWidth -= t;
                while (t-->0) {
                    res.append(" ");
                }
                left++;
            }
            res.append(words[right]);
        }
        
        return res.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        String[] words = {};
        List<String> res = s.fullJustify(words, 14);
        for (Iterator iterator = res.iterator(); iterator.hasNext();) {
            String string = (String) iterator.next();
            System.out.println("["+string+"]");
            
        }
    }

}
