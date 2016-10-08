package p134;

public class V1 {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		int start = 0, sum=0, i=0;
		while(i < gas.length){
			sum += gas[i] - cost[i];
			if(sum < 0){
				sum = 0;
				start = i+1;
			}
			i++;
		}
		
		return sum>=0&&start<gas.length ?start :-1;
	}

	public static void main(String[] args) {
		V1 v = new V1();
		int[] arr1 = {2,4};
		int[] arr2 = {3,4};
		
		System.out.println(v.canCompleteCircuit(arr1, arr2));
	}

}
