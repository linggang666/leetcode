package p357;

public class V1 {

	/**
	 * 使用排列组合
	 * @param n
	 * @return
	 */
	public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
		
        int nLevelCount = 1;
        for (int i = 0; i < n; i++) {
        	 nLevelCount = nLevelCount * (10-i);
		}
        nLevelCount = nLevelCount - (nLevelCount/10);
		return nLevelCount + countNumbersWithUniqueDigits(n-1);
    }
	
	public static void main(String[] args) {
		System.out.println((new V1()).countNumbersWithUniqueDigits(3));
	}

}
