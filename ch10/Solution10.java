package ch10;

class RankNode {
	public int toLeft = 0;
	public RankNode left;
	public RankNode right;
	public int val = 0;

	public RankNode(int d) {
		val = d;
	}

	public void insert(int d) {
		if (d <= val) {
			if (left != null) {
				left.insert(d); // recurse
			} else {
				left = new RankNode(d);
			}
			toLeft++;
		} else {
			if (right != null) {
				right.insert(d);
			} else {
				right = new RankNode(d);
			}
		}
	}

	public int getRank(int d) {
		if (d == val) {
			return toLeft;
		} else if (d < val) {
			if (left != null) {
				return left.getRank(d);
			}
		} else {
			if (right != null) {
				return toLeft + 1 + right.getRank(d);
			}
		}
		return -1;
	}
}

public class Solution10 {
	public static void main(String[] args) {

	}

}
