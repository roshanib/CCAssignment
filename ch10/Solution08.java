package ch10;

import java.util.BitSet;

public class Solution08 {

	public static void main(String[] args) {
		int[] array = { 1, 2, 4, 1, 3, 5, 7, 5 };
		checkDuplicates(array);
	}

	public static void checkDuplicates(int[] array) {
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++) {
			int num = array[i];
			int numMinusOne = num - 1;
			if (bs.get(numMinusOne)) {
				System.out.println(num);
			} else {
				bs.set(numMinusOne);
			}
		}
	}
}
