package ch10;

public class Solution01 {

	public static void main(String[] args) {
		int[] A = { 2, 5, 7, 9, 10, 0, 0, 0, 0, 0 };
		int[] B = { 1, 3, 6, 7, 8 };

		for (int x : sortedMerge(A, 5, B, 5)) {
			System.out.print(x + " ");
		}
	}

	private static int[] sortedMerge(int[] a, int i, int[] b, int j) {
		int aidx = i - 1, bidx = j - 1;
		int idx = a.length - 1;

		while (aidx >= 0 && bidx >= 0) {
			if (a[aidx] > b[bidx]) {
				a[idx] = a[aidx];
				aidx--;
			} else {
				a[idx] = b[bidx];
				bidx--;
			}

			idx--;
		}

		while (bidx >= 0) {
			a[idx] = b[bidx];
			idx--;
			bidx--;
		}
		return a;
	}

}
