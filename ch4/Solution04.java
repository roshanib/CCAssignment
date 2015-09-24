package ch4;

public class Solution04 {

	private static boolean checkBalanced(BstNode a) {
		return checkBalancedHelper(a) > -1;
	}

	private static int checkBalancedHelper(BstNode a) {
		if (a == null)
			return 0;
		if (a.left == null && a.right == null)
			return 1;

		int left = checkBalancedHelper(a.left);
		if (left < -1)
			return -1;

		int right = checkBalancedHelper(a.right);
		if (right < -1)
			return -1;

		int diff = Math.abs(left - right);
		if (diff > 1)
			return -1;
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		BstNode a = new BstNode(5);
		BstNode b = new BstNode(6);
		BstNode c = new BstNode(7);
		BstNode d = new BstNode(8);
		BstNode e = new BstNode(9);
		BstNode f = new BstNode(10);

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;

		System.out.println("This should be true : " + checkBalanced(a));
		e.left = f;
		System.out.println("This should be false : " + checkBalanced(a));
	}
}
