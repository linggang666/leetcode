package p119;

import java.util.Arrays;
import java.util.List;

public class V2 {
	
	/**
	 * 帕斯卡三角，公式不明白
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		Integer[] rowList = new Integer[rowIndex+1];
        rowList[0] = 1;
        for(int i=1; i<rowList.length;i++) {
            rowList[i] = (int)(rowList[i-1]*(rowIndex-(i-1))/(i));
        }
        return Arrays.asList(rowList);
	}
}
