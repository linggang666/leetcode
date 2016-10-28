package p146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {
	
	private int size;
	private Map<Integer, Integer> cache;
	private Map<Integer, Integer> count;
	private Queue<Integer> queue;
	
	public LRUCache(int capacity) {
		this.size = capacity;
		cache = new HashMap<Integer, Integer>();
		count = new HashMap<Integer, Integer>();
		queue = new LinkedList<>();
		
	}

	public int get(int key) {
		if(cache.containsKey(key)){
			count.put(key, count.get(key)+1);
			queue.add(key);
			return cache.get(key);
		}
		return -1;
	}

	public void set(int key, int value) {
		if(cache.containsKey(key)){
			count.put(key, count.get(key)+1);
			queue.add(key);
			cache.put(key, value);
			return;
		}
		
		if(this.cache.size() == this.size){
			while(count.get(queue.peek()) != 1){
				count.put(queue.peek(), count.get(queue.peek())-1);
				queue.poll();
			}
			count.remove(queue.peek());
			cache.remove(queue.poll());
		}
		
		count.put(key, 1);
		queue.add(key);
		cache.put(key, value);
	}
}
