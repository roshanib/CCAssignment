package ch10;

public class Solution09 {
	public static void main(String[] args) {
		int M = 10;
		int N = 5;
		int[][] matrix = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = 10 * i + j;
			}
		}

		System.out.println("Found element  11 : " + findElement(matrix, 11));
		System.out.println("Found element  8 : " + findElement(matrix, 8));

	}

	public static boolean findElement(int[][] matrix, int num) {
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < matrix.length && j >= 0) {
			if (matrix[i][j] == num) {
				return true;
			} else if (matrix[i][j] > num) {
				j--;
			} else {
				i++;
			}
		}
		return false;
	}

}
