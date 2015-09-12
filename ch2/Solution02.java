package ch2;

public class Solution02 {
	
	private class Node {
		int data;
		Node next;
	}

	public static void printKthLast(Node head, int k) {
		Node cur = head;
		Node kth = head;
		int i = 0;
		while (cur != null && i < k) {
			cur = cur.next;
			i++;
		}
		
		while (cur != null) {
			cur = cur.next;
			kth = kth.next;
		}
		
		System.out.println(kth.data);
	}
	
	

}
