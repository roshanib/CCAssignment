package ch5;

public class Solution03 {

	public static int flipBitToWin(int num) {
		if (~num == 0) return Integer.BYTES * 8;
		
		int n1 = 0;
		int n2 = 0;
		int max = 1;
		while (num != 0) {
			if ((num & 1) == 1) {
				n1++;
			} else if ((num & 1) == 0) {
				n2 = (num & 2) == 0 ? 0 : n1;
				n1 = 0;
			}
			max = Math.max(n2 + n1 + 1, max);
			num >>>= 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int n = 123;
		int x = flipBitToWin(n);
		System.out.println(n + " : " +x);
		n = 234;
		x = flipBitToWin(n);
		System.out.println(n + " : " +x);
	}

}
