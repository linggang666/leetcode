package p315;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class V1 {
	
	/**	
	 * 归并排序
	 * @param nums
	 * @return
	 */
	public List<Integer> countSmaller(int[] nums) {
		int[] counts = new int[nums.length];
		int[] pos = new int[nums.length];
		for (int i = 0; i < pos.length; i++) {
			pos[i] = i;
		}
		mergeSort(nums, 0,nums.length-1, counts, pos);
		List<Integer> res = new ArrayList<Integer>();
		for (int i : counts) {
			res.add(i);
		}
		return res;
	}
	

	private void mergeSort(int[] nums, int left, int right, int[] counts, int[] pos) {
		if(left >= right) return;
		int m = left+(right-left)/2;
		mergeSort(nums, left, m, counts, pos);
		mergeSort(nums, m+1, right, counts, pos);
		
		int[] tempPos = new int[right-left+1];
		int l=left, r=m+1, cnt=0, k=0;
		while(l<=m && r<=right){
			if(nums[pos[l]] <= nums[pos[r]]){
				counts[pos[l]] += cnt;
				tempPos[k++] = pos[l++];
			}else{
				cnt++;
				tempPos[k++] = pos[r++];
			}
		}
		
		while(l<=m){
			counts[pos[l]] += cnt;
			tempPos[k++] = pos[l++];
		}
		while(r<=right){
			tempPos[k++] = pos[r++];
		}
		
		for (int i = 0; i < tempPos.length; i++) {
			pos[left+i] = tempPos[i];
		}
	}


	public static void main(String[] args) {
		int[] a = { 5, 2, 6, 1 ,0};
		V1 v = new V1();
		System.out.println(Arrays.toString(v.countSmaller(a).toArray()));
	}
}
