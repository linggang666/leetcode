package p621;

import java.util.Arrays;

public class V1 {

    public static void main(String[] args) {
        V1 v = new V1();    
        char[] a = {'A','A','B','B','C','C','C','E','E','E'};
        System.out.println(v.leastInterval(a, 2));
    }

    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
}
