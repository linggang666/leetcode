package p070;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	
	Map<Integer, Integer> m = new HashMap<Integer, Integer>();
	public int climbStairs(int n) {
		if(n <= 2) return n;
		
		if(m.get(n) == null){
			m.put(n, climbStairs(n-1) + climbStairs(n-2));
		}
		return m.get(n);
	}
}
