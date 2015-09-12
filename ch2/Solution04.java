package ch2;

public class Solution04 {
	
	private class Node {
		int data;
		Node next;
	}

	public static Node partition(Node head, int partition) {
		Node result = null;
		Node lessEnd = null, greater = null, greaterEnd = null;
		
		Node cur = head;
		while (cur != null) {
			if (cur.data < partition) {
				if (result == null) {
					result = cur;
				} else {
					lessEnd.next = cur;
				}
					lessEnd = cur;
			} else {
				if (greater == null) {
					greater = cur;
					greaterEnd = cur;
				} else {
					greaterEnd.next = cur;
				}
				greaterEnd = cur;
			}
		}
		
		if (result == null) {
			result = greater;
		} else {
			lessEnd.next = greater;
		}
		return result;
	}

}
