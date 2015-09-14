
class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}
public class Solution05 {

	private static Node addReverse(Node head, Node head2) {
		Node result = null, cur = null;
		int carry = 0;
		while (head != null && head2 != null) {
			int sum = head.data + head2.data + carry;
			head = head.next;
			head2 = head2.next;
			Node newNode = new Node(sum%10);
			carry = sum/10;
			
			if (result == null) {
				result = newNode;
			} else {
				cur.next = newNode;
			}
			cur = newNode;
		}
		
		if (head != null) {
			cur.next = addReverse(head, new Node(carry));
		}
		
		if (head2 != null) {
			cur.next = addReverse(head2, new Node(carry));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Node head = new Node(7);
		Node filler = head;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(6); filler = filler.next;
		
		Node head2 = new Node(5);
		filler = head2;
		filler.next = new Node(9); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head2;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
		
		Node added = addReverse(head, head2);
		
		cur = added;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

}
