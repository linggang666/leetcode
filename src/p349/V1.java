package p349;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class V1 {
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null || nums1.length==0 || nums2.length==0){
			return new int[0];
		}
		
		Set<Integer> set1 = this.getSetFromArray(nums1);
		Set<Integer> set2 = this.getSetFromArray(nums2);
		set1.retainAll(set2);
		
		Iterator<Integer> iterator = set1.iterator();
		int[] result = new int[set1.size()];
		int i=0;
		while(iterator.hasNext()){
			result[i++] = iterator.next();
		}
		
		return result;
	}
	
	private Set<Integer> getSetFromArray(int[] nums){
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		return set;
	}
}
