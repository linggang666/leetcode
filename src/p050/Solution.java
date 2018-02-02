package p050;

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) 
            return 1;
        
        long n1 = n;
        if(n < 0) {
            x = 1/x;
            n1 = 0-n1;
        }
        
        double res = x;
        res = myPow(x*x, (int)(n1/2));
        if(n1%2==1) {
            res = res * x;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.myPow(0.5, 10));
        System.out.println(s.myPow(2 ,-2147483648));
    }
}
