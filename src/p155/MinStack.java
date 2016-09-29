package p155;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {
	
	Stack<Integer> stack = new Stack<>();
	List<Integer> minList = new ArrayList<Integer>();
	public MinStack() {
		
	}

	public void push(int x) {
		int size = stack.size();
		int min = x;
		if(size > 0){
			min = Math.min(min, minList.get(size-1));
		}
		minList.add(size,min);
		stack.push(x);
	}

	public void pop() {
		stack.pop();
		minList.remove(minList.size()-1);
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		if(stack.size()>0){
			return minList.get(stack.size()-1);
		}
		return -1;
	}
}
