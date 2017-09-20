package p049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V1 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(); 
        
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortStr = String.valueOf(arr);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<String>());
            list.add(str);
            map.put(sortStr, list);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            res.add(entry.getValue());
        }
        
        return res;
    }

}
