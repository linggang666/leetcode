package p121;

public class V4 {
	/**
	 * 3ms
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		int profit = 0, min = Integer.MAX_VALUE;
		for (int i : prices) {
			if(i < min){
				min = i;
			}else{
				profit = Math.max(i-min, profit);
			}
		}
		return profit;
	}
}
