package p347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class V1 {
	
	private Map<Integer, Integer> count = new HashMap<>();
	public List<Integer> topKFrequent(int[] nums, int k) {
		count.clear();
		
		for (int i : nums) {
			if(!count.containsKey(i)){
				count.put(i, 1);
			}else{
				count.put(i, count.get(i)+1);
			}
		}
		
		int[] keysArr = new int[count.size()];
		Iterator<Integer> iterator = count.keySet().iterator();
		int i = 0;
		while(iterator.hasNext()){
			keysArr[i++] = iterator.next();
		}
		
		buildHeap(keysArr);
		
		List<Integer> rank = new ArrayList<Integer>();
		int len = keysArr.length;
		while(k > 0 && len >=0){
			rank.add(keysArr[0]);
			
			int t = keysArr[0];
			keysArr[0] = keysArr[len-1];
			keysArr[len-1] = t;
			len--;k--;
			adjustHead(keysArr, 0, len);
		}
		
		return rank;
	}
	
	private void buildHeap(int[] arr){
		int len = arr.length;
		for (int i = len/2-1; i>=0; i--) {
			adjustHead(arr, i, len);
		}
	}
	
	private void adjustHead(int[] heap, int i, int size){
		int max = i;
		
		if(2*i+2 < size && count.get(heap[2*i+1]) < count.get(heap[2*i+2])){
			max = 2*i+2;
		}else if(2*i+1 < size){
			max = 2*i+1;
		}
		
		if(max!=i && count.get(heap[max])>count.get(heap[i])){
			int t = heap[i];
			heap[i] = heap[max];
			heap[max] = t;
			adjustHead(heap, max, size);
		}
	}

	public static void main(String[] args) {
		V1 v = new V1();
		int[] arr = {1,2,3,4,5,2,3,5,5,5,51,3,43,2,1};
		System.out.println(v.topKFrequent(arr, 2));

	}

}
