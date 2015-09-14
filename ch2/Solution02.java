
class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}
public class Solution02 {

	public static void printKthLast(Node head, int k) {
		Node cur = head;
		Node kth = head;
		int i = 0;
		// move one pointer k steps ahead
		while (cur != null && i < k) {
			cur = cur.next;
			i++;
		}
		
		// move both simultaneously k steps away frome ach other
		while (cur != null) {
			cur = cur.next;
			kth = kth.next;
		}
		
		System.out.println(kth.data);
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node filler = head;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(4); filler = filler.next;
		
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
		
		printKthLast(head, 3);;
	}
	
	

}
