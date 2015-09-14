public class Solution08 {

	public static void main(String[] args) {
		int[][]  matrix = { 
				{1, 2, 0},
				{3, 4, 5},
				{0, 6, 7},
				{8, 9, 10}
		};
		makeZero(matrix);
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void makeZero(int[][] matrix) {
		int rowLen = matrix.length;
		int coLen = matrix[0].length;
		
		int[] rows = new int[rowLen];
		int[] cols = new int[coLen];
		
		// Mark all rows and columns needed to be made zero
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = 1;
					cols[j] = 1;
				}
			}
		}
		// Mark complete rows zero
		for (int i=0; i<rowLen; i++) {
			if (rows[i] == 1) {
				for (int j=0; j<coLen; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		
		// Mark complete columns zero
		for (int i=0; i<coLen; i++) {
			if (cols[i] == 1) {
				for (int j=0; j<rowLen; j++) {
					matrix[j][i] = 0;
				}
			}
		}
	}
	
	

}
