package p084;

public class Solution2 {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        
        for (int i = 1; i < heights.length; i++) {
            int t = i-1;
            while(t>=0 && heights[t]>heights[i]) {
                res = Math.max(res, heights[t]*(i-t));
                heights[t] = heights[i];
                t--;
            }
        }
        for (int i = heights.length-1; i>=0; i--) {
            res = Math.max(res, heights[i]*(heights.length-i));
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(heights));
    }

}
