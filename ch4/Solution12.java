package ch4;

import java.util.HashMap;

public class Solution12 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BstNode root = Solution02.generateTree(array);
		System.out.println("There are " + pathsWithSum(root, 7) + " paths with sum");
	}

	private static int pathsWithSum(BstNode root, int sum) {
		return pathsWithSumHelper(root, sum, 0, new HashMap<>());
	}

	public static int pathsWithSumHelper(BstNode root, int targetSum, int runningSum, HashMap<Integer, Integer> map) {
		if (root == null)
			return 0;

		runningSum += root.val;

		int sum = runningSum - targetSum;
		int totalPaths = map.getOrDefault(sum, 0);

		if (runningSum == targetSum) {
			totalPaths++;
		}

		/* Add runningSum to pathCounts. */
		int newCount = map.getOrDefault(runningSum, 0) + 1;
		if (newCount == 0) {
			map.remove(runningSum);
		} else {
			map.put(runningSum, newCount);
		}

		/* Count paths with sum on the left and right. */
		totalPaths += pathsWithSumHelper(root.left, targetSum, runningSum, map);
		totalPaths += pathsWithSumHelper(root.right, targetSum, runningSum, map);

		/* Add runningSum to pathCounts. */
		newCount = map.getOrDefault(runningSum, 0) - 1;
		if (newCount == 0) {
			map.remove(runningSum);
		} else {
			map.put(runningSum, newCount);
		}
		return totalPaths;
	}
}
