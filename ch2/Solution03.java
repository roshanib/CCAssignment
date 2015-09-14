
class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}
public class Solution03 {

	public static void deleteMiddle(Node head) {
		if (head == null || head.next == null) return;
		//  Copy data from next node
		head.data = head.next.data;
		// Delete next node
		head.next = head.next.next;
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
		
		deleteMiddle(head.next.next);

		cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

}
