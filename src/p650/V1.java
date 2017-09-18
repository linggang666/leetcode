package p650;

import java.util.HashMap;
import java.util.Map;

public class V1 {

    public static void main(String[] args) {
        V1 v1 = new V1();
        for (int i = 0; i < 20; i++) {
            System.out.println(v1.minSteps(i));
        }

    }

    public int minSteps(int n) {
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        dp.put(1, 0);
        return _minSteps(n, dp);
    }
    
    public int _minSteps(int n, Map<Integer, Integer> dp) {
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        for (int i = 2; 2*i <= n; i++) {
            if(n%i == 0){
                if(!dp.containsKey(i)){
                    dp.put(i, i);
                }
                return dp.get(i) + _minSteps(n/i, dp);
            }
        }
        return n;
    }
}
