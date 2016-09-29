package p378;

public class V1 {

	public int kthSmallest(int[][] matrix, int k) {
		int heapSize=0;
		int len = matrix.length*matrix.length;
		int[] heap = new int[len];
		for (int[] is : matrix) {
			for (int i : is) {
				insertHeap(heap, heapSize++, i);
			}
		}
		
		while(k>1 && heapSize>=0){
			int t = heap[heapSize-1];
			heap[heapSize-1] = heap[0];
			heap[0] = t;
			
			k--;
			heapSize--;
			adjustHeap(heap, heapSize, 0);
		}
		
		return heap[0];
	}
	
	private void adjustHeap(int[] heap, int size, int i){
		int minIndex = i;
		if(i*2+2<size && heap[i*2+2] < heap[i*2+1]){
			minIndex = i*2+2;
		}else if(i*2+1<size){
			minIndex = i*2+1;
		}
		if(minIndex!=i && heap[i]>heap[minIndex]){
			int t = heap[i];
			heap[i] = heap[minIndex];
			heap[minIndex] = t;
			adjustHeap(heap, size, minIndex);
		}
	}
	
	private void insertHeap(int[] heap, int index, int value){
		if(index!=0){
			while((index-1)/2>=0 && heap[(index-1)/2]>value){
				heap[index] = heap[(index-1)/2];
				index = (index-1)/2;
			}
		}
		heap[index] = value;
	}

	public static void main(String[] args) {
		int[][] a = {
				{1,2,4},
				{3,5,6},
				{2,7,9}
		};
		int[][] b = {
				{-5}
		};
		V1 v = new V1();
		System.out.println(v.kthSmallest(b, 1));
		System.out.println((0-1)/2>=0);
	}

}
