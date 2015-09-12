package ch2;

import java.util.HashMap;
import java.util.HashSet;

public class Solution01 {
	
	private class Node {
		int data;
		Node next;
	}

	public Node removeDuplicates(Node head) {
		HashSet<Integer> map = new HashSet<>();
		Node result = head;
		Node prev = null;
		Node cur = head;
		while (cur != null) {
			if (map.contains(cur.data)) {
				if (prev == null) {
					result = cur.next;
				} else {
					prev.next = cur.next;
				}
			} else {
				map.add(cur.data);
			}
			prev = cur;
			cur = cur.next;
		}
		return result;
	}

}
