package p397;

import java.util.HashMap;
import java.util.Map;

public class V1 {

	Map<Integer, Integer> map = new HashMap();

	public int integerReplacement(int n) {

		if (n == 0) return 1;
		if (n == 1) return 0;
		if (n == Integer.MAX_VALUE) return 32;
		if (map.get(n) != null) return map.get(n);

		int count = 0;
		if (n % 2 == 0) {
			count = 1 + integerReplacement(n / 2);
		} else {
			count = 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
		}
		map.put(n, count);
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println((new V1()).integerReplacement(Integer.MAX_VALUE));
	}
}
