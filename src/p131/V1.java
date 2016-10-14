package p131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {

	private List<List<String>> partitions = new ArrayList<List<String>>();
	public List<List<String>> partition(String s) {
		partitions.clear();
		if(s == null || s.length() == 0) return this.partitions;
		
		List<String> temp = new ArrayList<>();
		_partition(s, temp, 0);
		return this.partitions;
	}
	private void _partition(String s, List<String> temp, int start) {
		if(start == s.length()){
			this.partitions.add(new ArrayList<>(temp));
			return;
		}
		
		for (int i = start; i < s.length(); i++) {
			if(isPalindrome(s,start,i)){
				temp.add(s.substring(start, i+1));
				_partition(s, temp, i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
	private boolean isPalindrome(String s, int start, int right) {
		while(start<right){
			if(s.charAt(start) != s.charAt(right)) return false;
			start++;
			right--;
		}
		return true;
	}
	
//	public static void main(String[] args) {
//		V1 v = new V1();
//		v.partition("cbbbcc");
//	}
}
