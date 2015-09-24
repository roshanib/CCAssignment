package ch4;

import java.util.Random;

class MyNode {
	public int val;
	public MyNode left;
	public MyNode right;
	private int size = 0; // to figure where to get the random node from

	public MyNode(int v) {
		val = v;
		size = 1;
	}

	public void insert(int v) {
		if (v <= val) {
			if (left == null) {
				left = new MyNode(v);
			} else {
				left.insert(v);
			}
		} else {
			if (right == null) {
				right = new MyNode(v);
			} else {
				right.insert(v);
			}
		}
		size++;
	}

	public MyNode find(int v) {
		if (v == val) {
			return this;
		} else if (v <= val) {
			return left != null ? left.find(v) : null;
		} else if (v > val) {
			return right != null ? right.find(v) : null;
		}
		return null;
	}

	public MyNode getRandomNode() {
		int leftSize = left == null ? 0 : left.size;
		Random random = new Random();
		int index = random.nextInt(size);
		if (index < leftSize) {
			return left.getRandomNode();
		} else if (index == leftSize) {
			return this;
		} else {
			return right.getRandomNode();
		}
	}
}

public class Solution11 {

	public static void main(String[] args) {
		MyNode root = new MyNode(5);
		root.insert(6);
		root.insert(1);
		root.insert(1);
		root.insert(9);
		root.insert(3);
		root.insert(7);
		root.insert(2);

		for (int i = 0; i < 8; i++) {
			System.out.print(root.getRandomNode().val + " ");
		}
	}

}
