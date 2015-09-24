package ch4;

import java.util.HashMap;

class Node {
	private Node adjacent[];
	public int adjacentCount;
	private String name;

	public Node(String name, int adjacentLength) {
		this.name = name;
		adjacentCount = 0;
		adjacent = new Node[adjacentLength];
	}

	public void addAdjacent(Node x) {
		if (adjacentCount < 30) {
			this.adjacent[adjacentCount] = x;
			adjacentCount++;
		} else {
			System.out.print("No more adjacent can be added");
		}
	}

	public Node[] getAdjacent() {
		return adjacent;
	}

	public String getName() {
		return name;
	}
}

public class Solution01 {

	public static boolean isPath(Node x, Node y, HashMap<Node, Boolean> visited) {
		if (x == null || visited.containsKey(x)) {
			return false;
		}
		if (x == y)
			return true;

		visited.put(x, true);
		Node[] adj = x.getAdjacent();
		for (int i = 0; i < x.adjacentCount; i++) {
			if (isPath(adj[i], y, visited)) {
				return true;
			}
		}
		visited.remove(x);
		return false;
	}

	public static void main(String[] args) {
		Node a = new Node("a", 3);
		Node b = new Node("b", 2);
		Node c = new Node("c", 2);
		Node d = new Node("d", 2);
		Node e = new Node("e", 2);
		Node f = new Node("f", 2);

		a.addAdjacent(b);
		a.addAdjacent(c);
		a.addAdjacent(d);
		b.addAdjacent(e);
		c.addAdjacent(f);
		d.addAdjacent(f);
		e.addAdjacent(f);

		System.out.println("Path exists between a and f : " + isPath(a, f, new HashMap<>()));
		System.out.println("Path exists between d and c : " + isPath(d, c, new HashMap<>()));

	}

}
