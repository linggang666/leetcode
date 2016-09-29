package p121;

public class V3 {
	/**
	 * 4ms
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0, min = Integer.MAX_VALUE;
		for (int i : prices) {
			min = Math.min(min, i);
			profit = Math.max(i-min, profit);
		}
		return profit;
	}
}
