import java.util.Stack;

class Node {
	int data;
	Node next;
	
	public Node(int num) {
		this.data = num;
		this.next = null;
	}
}

public class Solution06 {

	public static boolean isPalindrome(Node head) {
		Stack<Integer> st = new Stack<>();
		
		Node slow = head, fast = head;
		
		// store first half
		while (fast != null && fast.next != null) {
			st.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// for odd length
		if (fast != null) slow = slow.next;
		
		// compare now
		while (slow != null) {
			int val  = st.pop();
			if (slow.data != val) return false;
			slow= slow.next;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		Node filler = head;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(3); filler = filler.next;
		filler.next = new Node(2); filler = filler.next;
		filler.next = new Node(1); filler = filler.next;
		filler.next = new Node(1); filler = filler.next;
		
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.data + " ");
			cur = cur.next;
		}
		System.out.println();
		System.out.println(isPalindrome(head));
	}
}
