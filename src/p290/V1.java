package p290;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	public boolean wordPattern(String pattern, String str) {
		char[] charArr = pattern.toCharArray();
		String[] strArr = str.split(" ");
		if(charArr.length != strArr.length){
			return false;
		}
		
		Map<Character, String> maping = new HashMap<Character, String>();
		for (int i = 0; i < strArr.length; i++) {
			if(!maping.containsKey(charArr[i])){
				if(maping.containsValue(strArr[i])){
					return false;
				}
				maping.put(charArr[i], strArr[i]);
			}else if(!maping.get(charArr[i]).equals(strArr[i])){
				return false;
			}
		}
		
		return true;
	}
}
