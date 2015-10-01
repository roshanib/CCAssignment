package ch10;

public class Solution11 {

	public static void main(String[] args) {
		int[] array = { 1, 4, 2, 6, 3, 7, 4, 8, 3 };
		peaksAndValleys(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void peaksAndValleys(int[] array) {
		for (int i = 1; i < array.length; i += 2) {
			if (array[i - 1] < array[i]) {
				swap(array, i - 1, i);
			}
			if (i + 1 < array.length && array[i + 1] < array[i]) {
				swap(array, i + 1, i);
			}
		}
	}

	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
}
