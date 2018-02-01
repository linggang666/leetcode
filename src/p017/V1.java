package p017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class V1 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            if(!map.containsKey(digits.charAt(i))) {
                return new ArrayList<String>();
            }
            char[] lets = map.get(digits.charAt(i));
            List<String> temp = new ArrayList<String>();
            for (int j = 0; j < lets.length; j++) {
                for (int j2 = 0; j2 < res.size(); j2++) {
                    temp.add(res.get(j2)+lets[j]);
                }
            }
            res = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.letterCombinations("32"));
    }

}
