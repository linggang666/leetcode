package p029;

public class Solution {
    
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return 0;
        }
        
        long dividend1 = dividend, divisor1=divisor;
        boolean isNegative = false;
        if((dividend1<0 && divisor1>0) || (dividend1>0 && divisor1<0)) isNegative = true;
        if(dividend1 < 0) dividend1 = 0 - dividend1;
        if(divisor1 < 0) divisor1 = 0 - divisor1;
        
        char[] dividendChars = String.valueOf(dividend1).toCharArray();
        StringBuilder resStr = new StringBuilder();
        String subString = "0";
        for (int i = 0; i < dividendChars.length; i++) {
            subString += dividendChars[i];
            long t = Long.valueOf(subString);
            int t1 = 0;
            while(t>=divisor1) {
                t1++;
                t = t-divisor1;
            }
            resStr.append(t1);
            subString = String.valueOf(t);
        }
        
        long res = Long.valueOf(resStr.toString());
        if(isNegative) res = 0-res;
        return res>Integer.MAX_VALUE?Integer.MAX_VALUE:(int)res;
    }
    
    
    
    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.divide(-2147483648,1));
        System.out.println(s.divide(-2147483648, -1017100424));
    }

}
