package ch2;

import java.util.Stack;

public class Solution06 {
	
	private class Node {
		int data;
		Node next;
	}

	public static boolean isPalindrome(Node head) {
		Stack<Integer> st = new Stack<>();
		
		Node slow = head, fast = head;
		
		// store first half
		while (fast != null && fast.next != null) {
			st.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// for odd length
		if (fast.next != null) slow = slow.next;
		
		// compare now
		while (slow != null) {
			int val  = st.pop();
			if (slow.data != val) return false;
			slow= slow.next;
		}
		
		return true;
	}

}
