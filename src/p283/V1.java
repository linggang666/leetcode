package p283;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public void moveZeroes(int[] nums) {
		List<Integer> zeroIndexs = new ArrayList<Integer>();
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if(nums[i] == 0){
				zeroIndexs.add(i);
				continue;
			}
			
			if(!zeroIndexs.isEmpty()){
				int index = zeroIndexs.get(0);
				nums[index] = nums[i];
				nums[i] = 0;
				zeroIndexs.add(i);
				zeroIndexs.remove(0);
			}
		}
	}
}
