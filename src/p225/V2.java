package p225;

import java.util.LinkedList;
import java.util.Queue;

public class V2 {
	Queue<Integer> q1 = new LinkedList<Integer>();
	
	// Push element x onto stack.
	public void push(int x) {
		q1.add(x);
		int len = q1.size();
		while(len-- > 1){
			q1.add(q1.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		q1.poll();
	}

	// Get the top element.
	public int top() {
		return q1.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q1.isEmpty();
	}
}
