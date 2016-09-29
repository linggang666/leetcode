package p225;

import java.util.LinkedList;
import java.util.Queue;

public class V1 {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	
	// Push element x onto stack.
	public void push(int x) {
		if(this.q1.isEmpty()){
			q1.add(x);
			this.changeQueue(q2, q1);
		}else{
			q2.add(x);
			this.changeQueue(q1, q2);
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		this.getQueue().poll();
	}

	// Get the top element.
	public int top() {
		return this.getQueue().peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return this.getQueue().isEmpty();
	}
	
	private Queue<Integer> getQueue(){
		if(this.q1.isEmpty()){
			return q2;
		}
		return q1;
	}
	
	private void changeQueue(Queue<Integer> from, Queue<Integer> to){
		if(from.isEmpty()){
			return;
		}
		while(!from.isEmpty()){
			to.add(from.poll());
		}
	}
}
