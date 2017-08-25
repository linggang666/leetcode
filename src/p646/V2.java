package p646;

import java.util.Arrays;
import java.util.Comparator;

public class V2 {
    
    /**
     * greedy
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        
        int res = 0;
        int last = Integer.MIN_VALUE;
        for(int[] a: pairs){
            if(a[0] > last){
                res++;
                last = a[1];
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        int[][] arr = {
                {6,7},
                {1,2},
                {2,3},
                {3,4},
                {2,4}
        };
        
        V2 v = new V2();
        System.out.println(v.findLongestChain(arr));
    }
}
