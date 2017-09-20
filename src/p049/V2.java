package p049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V2 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(); 
        int[] count = new int[26];
        for(String str : strs){
            Arrays.fill(count, 0);
            for(char c: str.toCharArray()){
                count[c-'a'] ++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int cnt : count){
                sb.append("#").append(cnt);
            }
            
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        
        return new ArrayList<>(map.values());
    }

}
