package p435;

import java.util.Arrays;
import java.util.Comparator;

public class V1 {
	
	/**
	 * [ [1,2], [2,3], [1,3], [3,4] ]
	 * @param intervals
	 * @return
	 */
	public int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length < 2) return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.end < o2.end){
					return -1;
				}else if(o1.end>o2.end){
					return 1;
				}
				return 0;
			}
		});
		int res = 0;
		Interval t = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if(intervals[i].start < t.end){
				res++;
			}else{
				t = intervals[i];
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		Interval[] intervals = {
				new Interval(1, 2),
				new Interval(2, 3),
				new Interval(3, 4),
				new Interval(1, 3),
		};
		V1 v = new V1();
		System.out.println(v.eraseOverlapIntervals(intervals));
	}
}
