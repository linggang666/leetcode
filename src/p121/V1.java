package p121;

public class V1 {
	/**
	 * n方,超市
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				profit = Math.max(prices[j]-prices[i], profit );
			}
		}
		return profit;
	}
}
