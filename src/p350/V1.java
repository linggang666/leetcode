
package p350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if(nums1 == null || nums2 == null){
			return new int[0];
		}
		
		List<Integer> rl = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		
		int i1 = 0,i2 = 0;
		while(i1<nums1.length && i2<nums2.length){
			if(nums1[i1] == nums2[i2]){
				rl.add(nums1[i1]);
				i1++;
				i2++;
			}else if(nums1[i1] > nums2[i2]){
				i2++;
			}else {
				i1++;
			}
		}
		
		int[] result = new int[rl.size()];
		for (int i = 0; i < rl.size(); i++) {
			result[i] = rl.get(i);
		}
		return result;
	}
}
