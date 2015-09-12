package ch2;

public class Solution07 {

	private class Node {
		int data;
		Node next;
	}
	public static Node getIntersection(Node head1, Node head2) {
		Node result = null;
		
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		
		Node big = head2, small = head1;
		int diff = length2 - length1;;
		if (length1 > length2) {
			diff = length1- length2;
			big = head1; small = head2;
		}
		
		for (int i=0; i<diff; i++) {
			big = big.next;
		}
		
		while (big != null && small != null && big != small) {
			big = big.next;
			small = small.next;
		}
		
		result = big;
		
		return result;
	}
	private static int getLength(Node head) {
		int len = 0;
		while (head != null) {
			len++;
			head = head.next;
		}
		return len;
	}

}
