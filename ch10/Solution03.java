package ch10;

public class Solution03 {

	public static void main(String[] args) {
		int[] array = { 4, 7, 9, 10, 1, 2, 4 };

		System.out.println("Found at idx = " + search(array, 2));
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == nums[mid])
				return mid;

			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

}
