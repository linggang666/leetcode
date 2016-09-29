package p400;

public class V1 {
	public int findNthDigit(int n) {
		if(n < 10) return n;
		
		int power = 1;
		int preSum = 9;
		int base = 9;
		while(true){
			power++;
			base = (int) Math.pow(10, power-1);
			long curTH = 9L * base * power;
			if(n-preSum <= curTH){
				break;
			}
			preSum += curTH;
		}
		
		int num = base + (n-preSum)/power;
		int mod = (n-preSum)%power; 
		
		if(mod == 0){
			return (--num)%10;
		}else{
			return String.valueOf(num).charAt(mod-1)-'0';
		}
	}
	
	public static void main(String[] args) {
		System.out.println((new V1()).findNthDigit(1000000000));
	}
}
