package p665;

public class V1 {

    
    /**
     * [4,2,3]
     * [3,4,2,3]
     * [-1,4,2,3]
     * [2,3,3,2,4]
     * [3,3,2,2]
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int fixCnt = 0;
        for (int i = 1; i < len && fixCnt<=1; i++) {
            if(nums[i] < nums[i-1]){
                if(i==1 || nums[i]>= nums[i-2]){
                    nums[i-1] = nums[i-2];
                }else{
                    nums[i] = nums[i-1];
                }
                fixCnt ++;
            }
        }
        
        return fixCnt<=1;
    }

    public static void main(String[] args) {
        V1 v = new V1();
        int[] nums = {2,3,3,2,4};
        System.out.println(v.checkPossibility(nums));
    }

}
