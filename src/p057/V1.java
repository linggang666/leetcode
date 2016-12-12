package p057;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();
		int size = intervals.size();
		if(size==0){
			res.add(newInterval);
			return res;
		}
		
		for (int i = 0; i < size; i++) {
			Interval t = intervals.get(i);
			if(t.start>newInterval.end){
				res.add(newInterval);
				for (int j = i; j < size; j++) {
					res.add(intervals.get(j));
				}
				break;
			}else if(t.end<newInterval.start){
				res.add(t);
			}else{
				newInterval.start = Math.min(newInterval.start, t.start);
				newInterval.end = Math.max(newInterval.end, t.end);
			}
			if(i == size-1){
				res.add(newInterval);
			}
		}
		return res;
	}
}
