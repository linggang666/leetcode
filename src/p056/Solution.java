package p056;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0) {
            return res;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start > o2.start) {
                    return 1;
                }else if(o1.start < o2.start) {
                    return -1;
                }
                return 0;
            }
        });
        
        for (Interval interval : intervals) {
            if(res.isEmpty() || res.get(res.size()-1).end<interval.start) {
                res.add(interval);
            }else {
                res.get(res.size()-1).end = Math.max(interval.end, res.get(res.size()-1).end);
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(1, 9));

        System.out.println(intervals);
        System.out.println(s.merge(intervals));
    }

}
