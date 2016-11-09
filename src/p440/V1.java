package p440;

public class V1 {
	
	/**
	 * 十叉树
	 * @param n
	 * @param k
	 * @return
	 */
	public int findKthNumber(int n, int k) {
		int cur = 1;
		k--;
		while(k>0){
			int cnt = 0;
			long left = cur, right = cur+1;
			while(left <= n){
				cnt += Math.min(n+1, right) - left;
				left *= 10;
				right *= 10;
			}
			
			if(cnt <= k){
				cur++;
				k -= cnt;
			}else{
				cur *= 10;
				k--;
			}
		}
		return cur;
	}
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.findKthNumber(681692778, 681692778));
	}
}
