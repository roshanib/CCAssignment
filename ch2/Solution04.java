
class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}
public class Solution04 {

	public static Node partition(Node head, int partition) {
		Node result = null;
		Node lessEnd = null, greater = null, greaterEnd = null;
		
		Node cur = head;
		while (cur != null) {
			if (cur.data < partition) {
				// Add to left list
				if (result == null) {
					result = cur;
				} else {
					lessEnd.next = cur;
				}
				lessEnd = cur;
			} else {
				// Add to right list
				if (greater == null) {
					greater = cur;
					greaterEnd = cur;
				} else {
					greaterEnd.next = cur;
				}
				greaterEnd = cur;
			}
			cur = cur.next;
		}
		
		if (result == null) {
			// no left list -> no append needed
			result = greater;
		} else {
			// append left and right lists
			lessEnd.next = greater;
		}
		return result;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		Node filler = head;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(5); filler = filler.next;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(6); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(4); filler = filler.next;
		
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
		
		Node partitioned =  partition(head, 3);
		
		cur = partitioned;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

}
