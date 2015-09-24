package ch3;

import java.util.Stack;

class StackWithMin extends Stack<Integer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer> s2;

	public StackWithMin() {
		s2 = new Stack<Integer>();
	}

	public void push(int data) {
		if (data <= min()) {
			s2.push(data);
		}
		super.push(data);
	}

	public Integer pop() {
		int data = super.pop();
		if (data == min()) {
			s2.pop();
		}
		return data;
	}

	public int min() {
		if (s2.isEmpty()) {
			return Integer.MAX_VALUE;
		} else {
			return s2.peek();
		}
	}
}

public class Solution02 {

	public static void main(String[] args) {
		StackWithMin st = new StackWithMin();
		System.out.println("Pushing 2");
		st.push(2);
		System.out.println("Min : " + st.min());
		System.out.println("Pushing 4");
		st.push(4);
		System.out.println("Min : " + st.min());
		System.out.println("Pushing 1");
		st.push(1);
		System.out.println("Min : " + st.min());
		System.out.println("Pushing 5");
		st.push(5);
		System.out.println("Min : " + st.min());

	}

}
