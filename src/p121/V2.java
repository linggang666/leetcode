package p121;

public class V2 {
	/**
	 * 164ms 效率太低
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0;
		for (int i = 0; i < prices.length -1; i++) {
			if( prices[i] > prices[i+1]){
				continue;
			}
			for (int j = i; j < prices.length; j++) {
				profit = Math.max(prices[j]-prices[i], profit );
			}
		}
		return profit;
	}
}
