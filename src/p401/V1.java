package p401;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	private List<String> result = new ArrayList<String>(); 
	private int hour=0,minute=0;
	private int[] LEDs = {8,4,2,1,32,16,8,4,2,1}; 
	private int ledLen = 10;
	public List<String> readBinaryWatch(int num) {
		if(num == 0){
			result.add("0:00");
		}else{
			for (int i = 0; i < ledLen; i++) {
				_readBinaryWatch(i, num);
			}
		}
		return result;
    }
	
	private void _readBinaryWatch(int i, int num){
		if(ledLen-i < num) return;
		
		if(i<4){
			if(hour + LEDs[i]>11) return;
			hour = hour + LEDs[i];
		}else{
			if(minute + LEDs[i]>59) return;
			minute = minute + LEDs[i];
		}
		
		if(num==1) {
			result.add(String.format("%d:%02d", hour, minute));
		}else{
			for (int j = i+1; j < ledLen; j++) {
				_readBinaryWatch(j, num-1);
			}
		}
		
		if(i<4){
			hour = hour - LEDs[i];
		}else{
			minute = minute - LEDs[i];
		}
	}
	
	public static void main(String[] args) {
		(new V1()).readBinaryWatch(3);
	}

}
