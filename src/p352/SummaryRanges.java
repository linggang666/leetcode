package p352;

import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
	
	List<Interval> intervals = new LinkedList<>();
	public SummaryRanges() {
	}

	public void addNum(int val) {
		int start=val, end=val;
		int pos = getPos(val,0,intervals.size()-1);
		
		if(pos < this.intervals.size()){//end
			Interval right = this.intervals.get(pos);
			if(val >= right.start && val<= right.end) return;
			if(val == right.start-1){
				end = right.end;
				this.intervals.remove(pos);
			}
		}
		
		if(pos>0){//start
			Interval left = this.intervals.get(pos-1);
			if(val>=left.start && val<=left.end) return;
			if(val == left.end+1){
				start = left.start;
				this.intervals.remove(pos-1);
				pos--;
			}
		}
		
		this.intervals.add(pos, new Interval(start, end));
	}

	private int getPos(int val, int left, int right) {
		if(left > right) return left;
		
		int mid = left+(right-left)/2;
		Interval interval = intervals.get(mid);
		if(val==interval.end+1 ) return mid+1;
		if(val<=interval.end && val>=interval.start) return mid;
		if(val < interval.start) return getPos(val, left, mid-1);
		return getPos(val, mid+1, right);
	}

	public List<Interval> getIntervals() {
		return this.intervals;
	}
	
//	public static void main(String[] args) {
//		SummaryRanges s = new SummaryRanges();
//		s.addNum(6);
//		print(s.getIntervals());
//		s.addNum(6);
//		print(s.getIntervals());
//		s.addNum(0);
//		print(s.getIntervals());
//	}
//
//	private static void print(List<Interval> list) {
//		for(Interval i : list){
//			System.out.print("["+i.start+","+i.end+"] ,");
//		}
//		System.out.println();
//	}
}
