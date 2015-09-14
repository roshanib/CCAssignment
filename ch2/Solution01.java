import java.util.HashSet;

class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}

public class Solution01 {
	
	public static Node removeDuplicates(Node head) {
		HashSet<Integer> map = new HashSet<>();
		Node result = head;
		Node prev = null;
		Node cur = head;
		while (cur != null) {
			if (map.contains(cur.data)) {
				// its a duplicate
				if (prev == null) {
					// need to change head
					result = cur.next;
				} else {
					// found duplicate in middle dont update prev
					prev.next = cur.next;
					cur = cur.next;
					continue;
				}
			} else {
				// Found non duplicate node
				map.add(cur.data);
			}
			prev = cur;
			cur = cur.next;
		}
		return result;
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
		
		Node removed = removeDuplicates(head);
		
		cur = removed;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
	}

}
