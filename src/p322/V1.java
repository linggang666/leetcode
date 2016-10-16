package p322;

import java.util.Arrays;

import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;
import sun.tools.jar.resources.jar;

public class V1 {

	public int coinChange(int[] coins, int amount) {
		if(amount<1) return 0;
		
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= amount; i++) {
			for ( int j = 0; j < coins.length; j++) {
				if(coins[j] == i){
					dp[i] = 1;
				}else if(i-coins[j]>0 && dp[i-coins[j]]!=-1){
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
			if(dp[i] == Integer.MAX_VALUE) dp[i]=-1;
		}
        return dp[amount];
    }
	
	public static void main(String[] args) {
		int[] a = { 2, 5};
		V1 v = new V1();
		System.out.println(v.coinChange(a, 11));
	}
}
