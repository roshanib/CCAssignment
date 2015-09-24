package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution03 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		BstNode root = Solution02.generateTree(array);

		List<ArrayList<BstNode>> result = getLevels(root);
		for (int i = 0; i < result.size(); i++) {
			List<BstNode> l = result.get(i);
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j).val + "  ");
			}
			System.out.println();
		}
	}

	public static List<ArrayList<BstNode>> getLevels(BstNode root) {
		List<ArrayList<BstNode>> result = new ArrayList<>();
		LinkedList<BstNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			BstNode cur = q.removeFirst();
			ArrayList<BstNode> level = new ArrayList<>();
			while (cur != null) {
				level.add(cur);
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
				cur = q.removeFirst();
			}
			result.add(level);
			if (!q.isEmpty())
				q.add(null);
		}
		return result;
	}

}
