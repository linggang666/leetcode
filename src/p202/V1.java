package p202;

import java.util.HashSet;
import java.util.Set;

public class V1 {
	public boolean isHappy(int n) {

		Set<Integer> set = new HashSet<Integer>();
		while (n != 1) {
			int t = 0;
			while (n > 0) {
				t = (int) (t + Math.pow(n % 10, 2));
				n = n / 10;
			}
			if (set.contains(t)) {
				return false;
			}
			set.add(t);
			n = t;
		}

		return true;
	}

}
