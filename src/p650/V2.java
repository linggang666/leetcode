package p650;

import java.util.HashMap;
import java.util.Map;

public class V2 {

    public static void main(String[] args) {
        V2 v1 = new V2();
        for (int i = 0; i < 20; i++) {
            System.out.println(v1.minSteps(i));
        }

    }

    public int minSteps(int n) {
        if(n==1) return 0;
        for (int i = 2; i < n; i++) {
            if(n%i == 0){
                return i + minSteps(n/i);
            }
        }
        return n;
    }
    
}
