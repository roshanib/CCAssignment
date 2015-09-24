package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution09 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3 };
		BstNode root = Solution02.generateTree(array);
		System.out.println("Following are all possible arrays that could have led to this tree");
		List<LinkedList<Integer>> result = findArrays(root);
		for (int i = 0; i < result.size(); i++) {
			LinkedList<Integer> cur = result.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}
	}

	public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
			ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
		if (first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = new LinkedList<Integer>(prefix);
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}

		// Backtracking
		int head_1 = first.removeFirst();
		prefix.addLast(head_1);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		first.addFirst(head_1);
		int head_2 = second.removeFirst();
		prefix.addLast(head_2);
		weaveLists(first, second, results, prefix);
		prefix.removeLast();
		second.addFirst(head_2);
	}

	public static ArrayList<LinkedList<Integer>> findArrays(BstNode node) {
		ArrayList<LinkedList<Integer>> result = new ArrayList<>();

		if (node == null) {
			result.add(new LinkedList<Integer>());
			return result;
		}

		LinkedList<Integer> prefix = new LinkedList<>();
		prefix.add(node.val);

		ArrayList<LinkedList<Integer>> left = findArrays(node.left);
		ArrayList<LinkedList<Integer>> right = findArrays(node.right);

		for (LinkedList<Integer> l : left) {
			for (LinkedList<Integer> r : right) {
				ArrayList<LinkedList<Integer>> newList = new ArrayList<>();
				weaveLists(l, r, newList, prefix);
				result.addAll(newList);
			}
		}
		return result;
	}

}
