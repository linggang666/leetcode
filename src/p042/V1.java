package p042;

public class V1 {
	public int trap(int[] height) {
		
		int result = 0;
		int left=0,right=0;
		while(left < height.length-1){
			while(height[left] == 0) 
				if(++left == height.length-1)
					break;
			
			right = left+1;
			for (int i = right; i < height.length; i++) {
				if(height[i] >= height[left]) {
					right = i;
					break;
				}
				if(height[i]>=height[right]) right = i;
			}
			
			int min = Math.min(height[left], height[right]);
			int range = min * (right-left-1);
			for (int j = left+1; j < right; j++) {
				range -= height[j];
			}
			result += range;
			left = right;
		}
		return result;
    }
	
	public static void main(String[] args) {
		V1 v = new V1();
		int[] a = {0,1,0,2,1,0,1,3,2,1,2,4};
		System.out.println(v.trap(a));
		int[] b = {8,5,4,1,8,9,3,0,0};
		System.out.println(v.trap(b));
		int[] c = {4,2,3};
		System.out.println(v.trap(c));
	}
}
