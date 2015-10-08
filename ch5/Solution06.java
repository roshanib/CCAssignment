package ch5;

public class Solution06 {
	public static int conversion(int a, int b){
		int result = 0;
		for (int c = a ^ b; c != 0; c = c & (c-1)) {
			result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int a = 23432;
		int b = 512132;
		int bits = conversion(a, b);
		System.out.println("Need " + bits + " bit flips");
	}

}
