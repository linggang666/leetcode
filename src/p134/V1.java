package p134;

public class V1 {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		
		int len = gas.length;
		int diff = 0;
		for (int i = 0; i < len; i++) {
			diff += gas[i] - cost[i];
		}
		if(diff < 0 )return -1;
		
		int index = 0, sum=0, i=0;
		while(i < len){
			sum += gas[i] - cost[i];
			if(sum < 0){
				sum = 0;
				index = i+1;
			}
			i++;
		}
		
		return index;
	}

	public static void main(String[] args) {
		V1 v = new V1();
		int[] arr1 = {};
		int[] arr2 = {};
		
		System.out.println(v.canCompleteCircuit(arr1, arr2));
	}

}
