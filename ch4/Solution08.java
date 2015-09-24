package ch4;

public class Solution08 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BstNode root = Solution02.generateTree(array);

		BstNode one = root.left.left;
		BstNode two = root.left;
		BstNode three = root.left.right;

		System.out.println("Found correct ancestor? : " + (two == commonAncestor(one, three, root)));
	}

	private static BstNode commonAncestor(BstNode p, BstNode q, BstNode root) {
		if (root == null)
			return null;

		if (root == p || root == q)
			return root;

		// Look for keys in left and right subtrees
		BstNode keyLeft = commonAncestor(p, q, root.left);
		BstNode keyRight = commonAncestor(p, q, root.right);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		if (keyLeft != null && keyRight != null)
			return root;

		return (keyLeft != null) ? keyLeft : keyRight;
	}

}
