package p013;

public class V2 {
	
	public int romanToInt(String s) {
		
		int result = 0, pre=Integer.MAX_VALUE;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			int value = getInt4Roman(s.charAt(i));
			if(value > pre){
				result = result - pre - pre + value;
			}else{
				result += value;
			}
			pre = value;
		}
		
        return result;
    }
	
	private int getInt4Roman(char c){
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}
	
}