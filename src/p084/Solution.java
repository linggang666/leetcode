package p084;

public class Solution {

    /**
     * Time Limit Exceeded
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i]);
            int minHeight = heights[i];
            for (int j = i; j >= 0; j--) {
                minHeight = Math.min(minHeight, heights[j]);
                res = Math.max(res, (i-j+1)*minHeight);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(heights));
    }

}
