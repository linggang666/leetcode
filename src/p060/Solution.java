package p060;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {

        List<Integer> chars = new LinkedList<>();
        int[] cnts = new int[n+1];
        cnts[0] = 1;
        for (int i = 1; i <= n; i++) {
            cnts[i] = i*cnts[i-1];
            chars.add(i);
        }
        
        StringBuilder res = new StringBuilder();
        k--;
        for (int i = n-1; i >=0 ; i--) {
            int index = k/cnts[i];
            res.append(chars.remove(index));
            k = k-(index*cnts[i]);
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getPermutation(4, 2));
    }

}
