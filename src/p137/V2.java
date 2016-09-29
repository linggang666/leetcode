package p137;

public class V2 {
	
	
	/**
	 * 在discuss的解答中，使用了两个int整数表示状态以及位操作就完成了这种思路的全部计算。

%3运算只有三种状态：00,01,10，因此我们可以使用两个位来表示当前位%3。

对于每一位，我们让Two，One表示当前位的状态，B表示输入数字的对应位，Two+和One+表示输出状态。可以得到如下真值表

Two One B Two+ One+
0 0 0 0 0
0 0 1 0 1
0 1 0 0 1
0 1 1 1 0
1 0 0 1 0
1 0 1 0 0
1 1 0 X X (因为11状态不存在，可以忽略)
1 1 1 X X
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
        
		int one = 0;
        int two = 0;

        for (int i = 0; i < nums.length; i++){
            one = (~two) & (one ^ nums[i]);
            two = (~one) & (two ^ nums[i]);
        }
        return one;
    }
	
	public static void main(String[] args) {
		int[] a = {8,2,2,2};
		V2 v = new V2();
		System.out.println(v.singleNumber(a));
	}

}
