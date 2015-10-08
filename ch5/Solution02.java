package ch5;

public class Solution02 {
	public static String ERROR = "ERROR";
	public static void printNumberBinary(double num) {
		if (num >= 1 || num <= 0) {
			System.out.println(ERROR);
			return;
		}
	
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		while (num > 0) {
			/* Setting a limit on length: 32 characters */
			if (sb.length() > 32) {
				System.out.println(ERROR);
				return;
			}
			double r = num * 2;
			if (r >= 1) {
				sb.append(1);
				num = r - 1;
			} else {
				sb.append(0);
				num = r;
			}
		}
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) {
		printNumberBinary(0.5);
		printNumberBinary(0.2);
	}

}
