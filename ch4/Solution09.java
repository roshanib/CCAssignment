package ch4;

import java.util.ArrayList;
import java.util.List;

public class Solution09 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };
		BstNode root = Solution02.generateTree(array);
		System.out.println("Following are all possible arrays that could have led to this tree");
		List<ArrayList<Integer>> result = findArrays(root);
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> cur = result.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}
	}

	private static List<ArrayList<Integer>> findArrays(BstNode root) {
		// TODO Auto-generated method stub
		return null;
	}

}
