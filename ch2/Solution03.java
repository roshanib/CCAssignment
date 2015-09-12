package ch2;

public class Solution03 {
	
	private class Node {
		int data;
		Node next;
	}

	public static void deleteMiddle(Node head) {
		if (head == null || head.next == null) return;
		head.data = head.next.data;
		head.next = head.next.next;
	}

}
