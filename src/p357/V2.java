package p357;

public class V2 {

	/**
	 * 回溯法
	 * @param n
	 * @return
	 */
	public int countNumbersWithUniqueDigits(int n) {
        int count = 0;
        int max = (int) Math.pow(10, n) - 1;
        max = 120;
        while(max >= 0){
        	int repeatPos = getStepPow(max);
        	if(repeatPos == -1){
        		count++;
        		max--;
        	}else{
        		max =  max - (int)Math.pow(10, repeatPos);
        	}
        }
        return count;
    }
	
	public int getStepPow(int i){
		int[] arr = new int[10];
		char[] charArr = String.valueOf(i).toCharArray();
		
		for (int j = 0; j < charArr.length; j++) {
			if(arr[charArr[j]-'0'] != 0){
				return charArr.length-j-1;
			}
			arr[charArr[j]-'0'] = 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println((new V2()).countNumbersWithUniqueDigits(0));
		System.out.println((new V2()).countNumbersWithUniqueDigits(1));
		System.out.println((new V2()).countNumbersWithUniqueDigits(2));
		System.out.println((new V2()).countNumbersWithUniqueDigits(3));
	}

}
