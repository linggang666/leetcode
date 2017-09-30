package p518;

public class V2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = dp[j] + dp[j-coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        V2 v = new V2();
        int[] coins = new int[] { 1, 2, 5 };
        System.out.println(v.change(5000, coins));
    }
}
