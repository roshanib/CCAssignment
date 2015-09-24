package ch3;

import java.util.Stack;

class MyQueue<T> {
	Stack<T> st1;
	Stack<T> st2;

	public MyQueue() {
		st1 = new Stack<T>();
		st2 = new Stack<T>();
	}

	public int size() {
		return st1.size() + st2.size();
	}

	public void add(T value) {
		st1.push(value);
	}

	private void shiftStacks() {
		if (st2.isEmpty()) {
			while (!st1.isEmpty()) {
				st2.push(st1.pop());
			}
		}
	}

	public T peek() {
		shiftStacks();
		return st2.peek();
	}

	public T remove() {
		shiftStacks();
		return st2.pop();
	}

}

public class Solution04 {

	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<>();

		System.out.println("Add 3");
		q.add(3);
		System.out.println("Add 4");
		q.add(4);
		System.out.println("Peek :  " + q.peek());
		System.out.println("Removed " + q.remove());
		System.out.println("Add 2");
		q.add(2);
		System.out.println("Add 6");
		q.add(6);
		System.out.println("Add 7");
		q.add(7);
		System.out.println("Peek :  " + q.peek());
		System.out.println("Removed " + q.remove());
		System.out.println("Peek :  " + q.peek());
		System.out.println("Removed " + q.remove());

	}

}
