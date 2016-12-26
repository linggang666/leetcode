package p372;

public class V1 {
	
	/**
	 * 快速幂取模
	 */
	public int superPow(int a, int[] b) {  
	    int res = 1;  
	    for (int i = 0; i < b.length; i++) {  
	        res = pow(res, 10) * pow(a, b[i]) % 1337;   //？
	    }  
	    return res;  
	}  
	  
	public int pow(int a, int b) {  
	    if (b == 0) return 1;  
	    if (b == 1) return a % 1337;  
	    a = a % 1337;
	    return pow(a, b>>1) * pow(a, b - (b>>1)) % 1337;  
	} 
	
	public static void main(String[] args) {
	}
	
}
