package ch2;

public class Solution08 {
	
	private class Node {
		int data;
		Node next;
	}

	public static Node getLoopBeginning(Node head) {
		Node fast = head, slow = head;
		
		// find intersection 
		while (fast != slow) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// find size of loop
		int size = 1;
		fast = slow.next;
		while (fast != slow) {
			fast = fast.next;
			size++;
		}
		
		// Get both nodes to beginning
		fast = head; slow = head;
		
		// move fast size steps away from slow
		for (int i=0; i<size; i++) {
			fast = fast.next;
		}
		
		// Next where they meet will be beginning of the loop since beginning 
		// of the loop is size steps away from itself
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return fast;
	}

}
