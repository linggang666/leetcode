package p093;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		_restoreIp(s, 0, res, new ArrayList<Integer>());
		return res;
    }

	private void _restoreIp(String s, int i, List<String> res, ArrayList<Integer> temp) {
		if(i==s.length() || temp.size()==4){
			if(i==s.length() && temp.size()==4){
				res.add(temp.get(0)+"."+temp.get(1)+"."+temp.get(2)+"."+temp.get(3));
			}
			return;
		}
		
		int len = s.charAt(i)=='0'?1:3;
		len = Math.min(len, s.length()-i);
		for (int j = 0; j < len; j++) {
			int num = Integer.parseInt(s.substring(i, i+j+1));
			if(num>255)
				return;
			temp.add(num);
			_restoreIp(s, i+j+1, res, temp);
			temp.remove(temp.size()-1);
		}
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		v.restoreIpAddresses("00100");
	}
}
