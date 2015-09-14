
class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}
public class Solution07 {
	
	public static Node getIntersection(Node head1, Node head2) {
		Node result = null;
		
		int length1 = getLength(head1);
		int length2 = getLength(head2);
		
		// find big, small and length difference
		Node big = head2, small = head1;
		int diff = length2 - length1;;
		if (length1 > length2) {
			diff = length1- length2;
			big = head1; small = head2;
		}
		
		// Advance big by diff steps
		for (int i=0; i<diff; i++) {
			big = big.next;
		}
		
		// Advance both together till they meet
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
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node filler = head;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		Node inter = filler;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(4); filler = filler.next;
		
		Node second = new Node(3);
		filler = second;
		filler.next = new Node(4); filler = filler.next;
		filler.next = new Node(5); filler = filler.next;
		filler.next = inter;

		Node intersectionFound = getIntersection(head, second);
		boolean correct = inter == intersectionFound;
		System.out.println("Found correct intersection : " + correct);
	}

}
