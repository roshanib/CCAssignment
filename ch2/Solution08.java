
class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}
public class Solution08 {
	
	public static Node getLoopBeginning(Node head) {
		Node fast = head.next, slow = head;
		
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
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node filler = head;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(3); filler = filler.next;
		Node begin = filler;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(4); filler = filler.next;
		filler.next = begin;
		
		Node beginning = getLoopBeginning(head);
		
		boolean correct = begin == beginning;
		System.out.println("Beginning found is correct : " + correct);
		
	}

}
