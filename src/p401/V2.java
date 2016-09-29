package p401;

import java.util.ArrayList;
import java.util.List;

public class V2 {
	
	public List<String> readBinaryWatch(int num) {
	    List<String> times = new ArrayList<>();
	    for (int h=0; h<12; h++)
	        for (int m=0; m<60; m++)
	            if (Integer.bitCount(h * 64 + m) == num)
	                times.add(String.format("%d:%02d", h, m));
	    return times;        
	}
	
	public static void main(String[] args) {
		(new V2()).readBinaryWatch(3);
	}

}
