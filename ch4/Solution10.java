package ch4;

public class Solution10 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BstNode root = Solution02.generateTree(array);
		int[] subarray = { 1, 2, 3, 4 };
		BstNode subroot = Solution02.generateTree(subarray);
		System.out.println("This shoudl return true : " + isSubtree(root, subroot));

		int[] subarray2 = { 1, 2, 3 };
		BstNode subroot2 = Solution02.generateTree(subarray2);
		System.out.println("This shoudl return false : " + isSubtree(root, subroot2));

	}

	private static boolean isSubtree(BstNode root, BstNode subroot) {
		if (root == null)
			return subroot == null;
		if (subroot == null)
			return true;
		if (root.val == subroot.val) {
			if (matchTree(root, subroot))
				return true;
		}
		return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
	}

	private static boolean matchTree(BstNode root, BstNode subroot) {
		if (root == null)
			return subroot == null;
		if (subroot == null)
			return false;
		if (root.val != subroot.val)
			return false;
		return matchTree(root.left, subroot.left) && matchTree(root.right, subroot.right);
	}

}
