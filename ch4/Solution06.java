package ch4;

public class Solution06 {

	public static void main(String[] args) {
		int[] valid = { 1, 2, 3, 4, 5, 6, 7 };
		BstNode v = Solution02.generateTree(valid);

		System.out.println("Inorder successor of root is : " + inorderSuccessor(v, v).val);
	}

	private static BstNode inorderSuccessor(BstNode v, BstNode root) {
		BstNode result = null;
		if (v.right != null) {
			result = v.right;
			while (result.left != null) {
				result = result.left;
			}
			return result;
		}

		// Start from root and search for successor down the tree
		while (root != null) {
			if (v.val < root.val) {
				result = root;
				root = root.left;
			} else if (v.val > root.val)
				root = root.right;
			else
				break;
		}
		return result;
	}

}
