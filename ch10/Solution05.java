package ch10;

public class Solution05 {

	public static void main(String[] args) {
		String[] array = { "at", "", "", "", "ball", "", "", "cat", "", "", "dad", "", "" };

		System.out.println(search(array, "cat"));
	}

	public static int search(String[] strings, String str, int top, int bottom) {
		if (top > bottom) {
			return -1;
		}

		/* Move mid to the middle */
		int mid = (bottom + top) / 2;

		/* If mid is empty, find closest non-empty string. */
		if (strings[mid].isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (left < top && right > bottom) {
					return -1;
				} else if (right <= bottom && !strings[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= top && !strings[left].isEmpty()) {
					mid = left;
					break;
				}
				right++;
				left--;
			}
		}

		/* Check for string, and recurse if necessary */
		if (str.equals(strings[mid])) { // Found it!
			return mid;
		} else if (strings[mid].compareTo(str) < 0) { // Search right
			return search(strings, str, mid + 1, bottom);
		} else { // Search left
			return search(strings, str, top, mid - 1);
		}
	}

	public static int search(String[] strings, String str) {
		if (strings == null || str == null || str.isEmpty()) {
			return -1;
		}
		return search(strings, str, 0, strings.length - 1);
	}
}
