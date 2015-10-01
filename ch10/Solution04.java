package ch10;

import java.util.ArrayList;

public class Solution04 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

		ArrayList<Integer> list = new ArrayList<>();
		for (Integer i : array) {
			list.add(i);
		}
		System.out.println("Found at idx = " + search(list, 2));

	}

	public static int binarySearch(ArrayList<Integer> list, int value, int low, int high) {
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;
			int middle = list.get(mid);
			if (middle > value || middle == -1) {
				high = mid - 1;
			} else if (middle < value) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static int search(ArrayList<Integer> list, int value) {
		int index = 1;
		while (list.get(index) != -1 && list.get(index) < value) {
			index *= 2;
		}
		return binarySearch(list, value, index / 2, index);
	}

}
