package p502;

public class V1 {

    /**
     *Time Limit Exceeded
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        boolean[] flag = new boolean[Profits.length];
        return this._findMaximizedCapital(k, W, Profits, Capital, flag)+W;
    }
    
    private int _findMaximizedCapital(int k, int W, int[] Profits, int[] Capital, boolean[] flag) {
        if(k<=0) 
            return 0;
        
        int res = 0;
        for (int i = 0; i < Capital.length; i++) {
            if(!flag[i] && Capital[i]<=W){
                flag[i] = true;
                int sub = _findMaximizedCapital(k-1, W+Profits[i], Profits, Capital, flag);
                res = Math.max(res, Profits[i] + sub);
                flag[i] = false;
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        V1 v = new V1();
        int[] Profits = {1,2,3};
        int[] Capital = {11,12,13};
        System.out.println(v.findMaximizedCapital(11, 11, Profits, Capital));
    }

}
