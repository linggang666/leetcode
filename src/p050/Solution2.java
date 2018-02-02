package p050;

public class Solution2 {
    public double myPow(double x, int n) {
        if(n == 0) 
            return 1;
        
        long n1 = n;
        if(n < 0) {
            x = 1/x;
            n1 = 0-n1;
        }
        
        double res = 1, cur=x;
        while(n1>0) {
            if(n1%2==1) {
                res = res * cur;
            }
            cur = cur * cur;
            n1 = n1/2;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.myPow(0.5, 10));
        System.out.println(s.myPow(2 ,-2147483648));
    }
}
