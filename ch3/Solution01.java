package ch3;

class MultiStack {
	private class StackInfo {
		int start, size, capacity;

		public StackInfo(int start, int capacity) {
			this.start = start;
			this.capacity = capacity;
		}

		public boolean isFull() {
			return size == capacity;
		}

		public int lastElementIndex() {
			return (start + size - 1) % values.length;
		}

		public boolean isEmpty() {
			return size == 0;
		}

	}

	StackInfo[] stacks;
	int[] values;

	public MultiStack(int number, int defaultSize) {
		stacks = new StackInfo[number];
		for (int i = 0; i < number; i++) {
			stacks[i] = new StackInfo(i * defaultSize, defaultSize);
		}
		values = new int[number * defaultSize];
	}

	public void push(int stackNum, int value) {
		/*
		 * if (allstacks are full) { throw Exception(); }
		 */
		StackInfo stack = stacks[stackNum];
		if (stack.isFull()) {
			expand(stackNum);
		}

		stack.size++;
		values[stack.lastElementIndex()] = value;
	}

	private void expand(int stackNum) {
		/*
		 * we will move the next stack and increase capacity of current stack
		 */
		shift((stackNum + 1) % stacks.length);
		stacks[stackNum].capacity++;
	}

	private void shift(int i) {
		/*
		 * we can move the next stack to one step ahead. We can reduce the
		 * capacity of the next stack if it is possibel, that is if it is not
		 * full Otherwise we need to shift the next stack as well
		 */

	}

	/* Remove value from stack. */
	public int pop(int stackNum) {
		StackInfo stack = stacks[stackNum];
		/*
		 * if (stack.isEmpty()) { throw new Exception(); }
		 */

		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size--;
		return value;
	}

	/* Get top element of stack. */
	public int peek(int stackNum) {
		StackInfo stack = stacks[stackNum];
		return values[stack.lastElementIndex()];
	}
}

public class Solution01 {

	public static void main(String[] args) {
		/*
		 * Not a working code. Have explained how the code would work and
		 * written down functions that would be needed
		 */

	}

}
