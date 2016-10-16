package p011;

public class V1 {
	
	public int maxArea(int[] height) {
		int max = 0;
		int l=0,r=height.length-1;
		while (l<r) {
			int low = Math.min(height[l], height[r]);
			max = Math.max(max, low * (r-l));
			if(height[l]>height[r]){
				r--;
			}else{
				l++;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {3,4,6,2,5};
		V1 v = new V1();
		System.out.println(v.maxArea(a));
	}
}
