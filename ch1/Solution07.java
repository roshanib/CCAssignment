public class Solution07 {

	public static void main(String[] args) {
		int[][] matrix = { 
				{1, 2}, 
				{3, 4} 
				};
		rotate(matrix);
		for (int i=0; i<matrix.length; i++) {
			for( int j=0; j<matrix.length; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
	}

	private static void rotate(int[][] matrix) {
		int length = matrix.length;
		for (int i=0; i<length/2;  i++) {
			int first = i, last = length-1-i;
			for (int j=first; j<last; j++) {
				int temp = matrix[first][j];
				matrix[first][j] = matrix[last-j+first][first];
				matrix[last-j+first][first] = matrix[last][last-j+first];
				matrix[last][last-j+first] = matrix[j][last];
				matrix[j][last] = temp;
			}
		}
	}

}
