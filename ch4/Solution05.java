package ch4;

public class Solution05 {

	public static void main(String[] args) {
		int[] valid = { 1, 2, 3, 4, 5, 6, 7 };
		BstNode v = Solution02.generateTree(valid);

		System.out.println("This should be true : " + checkValid(v));

		int[] invalid = { 1, 2, 3, 5, 4, 6, 7 };
		BstNode iv = Solution02.generateTree(invalid);

		System.out.println("This should be false : " + checkValid(iv));
	}

	private static boolean checkValid(BstNode v) {
		return checkValidHelper(v, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkValidHelper(BstNode v, int minValue, int maxValue) {
		if (v == null)
			return true;
		if (minValue > v.val || v.val > maxValue) {
			return false;
		}
		return checkValidHelper(v.left, minValue, v.val) && checkValidHelper(v.right, v.val, maxValue);
	}

}
