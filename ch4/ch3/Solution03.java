package ch3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

class StackSet {
	List<Stack<Integer>> stacks = new ArrayList<>();
	int capacity;

	public StackSet(int capacity) {
		this.capacity = capacity;
	}

	private Stack<Integer> getLastStack() {
		if (stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}

	public void push(int v) {
		Stack<Integer> last = getLastStack();
		if (last == null || last.size() >= this.capacity) {
			last = new Stack<Integer>();
			stacks.add(last);
		}
		last.push(v);
	}

	public int pop() {
		Stack<Integer> last = getLastStack();
		if (last == null)
			throw new EmptyStackException();
		int v = last.pop();
		if (last.size() == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return v;
	}

	public int leftShift(int index, boolean removeTop) {
		Stack<Integer> stack = stacks.get(index);
		int removed_item;
		if (removeTop)
			removed_item = stack.pop();
		else
			removed_item = stack.firstElement();
		if (stack.isEmpty()) {
			stacks.remove(index);
		} else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}

	public int popAt(int index) {
		return leftShift(index, true);

	}
}

public class Solution03 {

	public static void main(String[] args) {
		StackSet stSet = new StackSet(4);

		stSet.push(1);
		stSet.push(1);
		stSet.push(1);
		stSet.push(1);

		stSet.push(2);
		stSet.push(2);
		stSet.push(2);
		stSet.push(2);

		stSet.push(3);
		stSet.push(3);
		stSet.push(3);
		stSet.push(3);

		stSet.push(4);

		System.out.println("Pop : " + stSet.pop());
		System.out.println("PopAt 1 : " + stSet.popAt(1));
		System.out.println("PopAt 1 : " + stSet.popAt(1));
		System.out.println("PopAt 1 : " + stSet.popAt(1));
	}

}
