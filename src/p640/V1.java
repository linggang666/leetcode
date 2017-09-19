package p640;

import java.util.Arrays;

public class V1 {

    public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.solveEquation("-x=-1"));
    }
    
    public String solveEquation(String equation) {
        int[] left = this.parseExpression(equation.substring(0, equation.indexOf('=')));
        int[] right = this.parseExpression(equation.substring(equation.indexOf('=')+1));
        
        if(Arrays.equals(left, right)){
            return "Infinite solutions";
        }
        if(left[0] == right[0]){
            return "No solution";
        }
        
        int res = (right[1]-left[1]) / (left[0] - right[0]);
        return "x="+res;
    }
    
    
    private int[] parseExpression(String str){
        int[] res = {0,0};
        int left = 0;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                this.parseToken(res, str.substring(left, i));
                left = str.charAt(i) == '+' ? i+1 : i;
            }
        }
        this.parseToken(res, str.substring(left));
        return res;
    }
    
    private void parseToken(int[] res, String token){
        if(token.indexOf('x') >= 0){
            token = token.substring(0, token.length()-1);
            int rate = token.length()==0 || token.equals("-")? Integer.parseInt(token+"1") : Integer.parseInt(token);
            res[0] += rate;
        }else{
            res[1] += Integer.parseInt(token);
        }
    }
    
}
