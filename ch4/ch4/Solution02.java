package ch4;

class BstNode {
	int val;
	BstNode left;
	BstNode right;

	public BstNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class Solution02 {

	public static BstNode generateTree(int[] array) {
		return generateTreeHelper(array, 0, array.length - 1);
	}

	private static BstNode generateTreeHelper(int[] array, int begin, int end) {
		if (begin > end)
			return null;

		int mid = begin + (end - begin) / 2;

		BstNode root = new BstNode(array[mid]);
		root.left = generateTreeHelper(array, begin, mid - 1);
		root.right = generateTreeHelper(array, mid + 1, end);
		return root;

	}

	public static void displayTree(BstNode root) {
		if (root != null) {
			displayTree(root.left);
			System.out.print(" " + root.val);
			displayTree(root.right);
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		BstNode root = generateTree(array);
		displayTree(root);
	}
}
