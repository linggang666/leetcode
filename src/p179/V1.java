package p179;

public class V1 {
	public String largestNumber(int[] nums) {
		if(nums.length == 0) return "0";
		
		String[] strs = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strs[i] = String.valueOf(nums[i]);
		}
		String[] sortNums = mergeSort(strs, 0, strs.length-1);
		
		if(sortNums[0].equals("0")) return "0";
		
		StringBuilder sb = new StringBuilder();
		for (String str : sortNums) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	
	private String[] mergeSort(String[] strs, int left, int right) {
		if(left == right){
			return new String[]{strs[left]};
		}
		
		int mid = left + (right-left)/2;
		String[] l = mergeSort(strs, left, mid);
		String[] r = mergeSort(strs, mid+1, right);
		
		String[] res = new String[right-left+1];
		int i=0, li=0, ri=0;
		while(li < l.length && ri<r.length){
				res[i++] = compare(l[li], r[ri]) > 0?l[li++]:r[ri++];
		}
		while(li < l.length) res[i++] = l[li++];
		while(ri < r.length) res[i++] = r[ri++];
		
		return res;
	}
	
	public int compare(String s1, String s2){
		String s = s1;
		s1 = s1 + s2;
		s2 = s2 + s;
		return s1.compareTo(s2);
	}


	public static void main(String[] args) {
		int[] arr = {2,1};
		V1 v = new V1();
		System.out.println(v.largestNumber(arr));
	}
}
