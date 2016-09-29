package p137;

public class V1 {
	
	public int singleNumber(int[] nums) {
        
		int[] bits = new int[32];
		for (int i : nums) {
			for (int j = 0; j < 32 && i!=0; j++) {
				bits[j] += i & 1;
				i >>= 1;
			}
		}
		
		int single = 0;
		for (int i = 0; i < bits.length; i++) {
			if(bits[i] % 3 != 0){
				single += 1<<i;
			}
		}
		
		return single;
    }
	
	public static void main(String[] args) {
		int[] a = {8,2,2,2,5,5,5};
		V1 v = new V1();
		System.out.println(v.singleNumber(a));
	}

}
