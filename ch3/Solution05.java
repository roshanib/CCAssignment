package ch3;

import java.util.Stack;

public class Solution05 {

	private static void sortStack(Stack<Integer> st) {
		Stack<Integer> temp = new Stack<>();

		while (!st.isEmpty()) {
			temp.push(st.pop());
		}

		while (!temp.isEmpty()) {
			int top = temp.pop();

			while (!st.isEmpty() && st.peek() < top) {
				temp.push(st.pop());
			}

			st.push(top);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();

		st.push(5);
		st.push(2);
		st.push(3);
		st.push(1);
		st.push(4);

		sortStack(st);

		while (!st.isEmpty()) {
			System.out.println(st.pop());
		}

	}

}
