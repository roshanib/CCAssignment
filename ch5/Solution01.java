package ch5;

public class Solution01 {
	public static int insertion(int n, int m, int i, int j) {
		if (i >= 32 || j < i) {
			return 0;
		}
		
		int allOnes = ~0; 
		
		int left = allOnes << (j + 1); // 1s till j
	  	int right = ((1 << i) - 1); // 1s after i
		int mask = left | right; // combination of above two

		int cleared_bits = n & mask; // clear bits to be updated
		int m_at_position = m << i; // move at required position
		
		return cleared_bits | m_at_position; 
	}
	
	public static void main(String[] args) {
		int a = 103217;
		printNumberBinary(a, "a : ");
		int b = 13;
		printNumberBinary(b, "b : ");
		int i=4, j=12;
		System.out.println("i : " + i + " j : " + j);
		int c = insertion(a, b, 4, 12);
		printNumberBinary(c, "c : ");
	}

	public static void printNumberBinary(int a, String string) {
		StringBuilder sb = new StringBuilder();
		while (a > 0) {
		    sb.insert(0, Integer.toString(a%2));
		    a /= 2;
		}
		System.out.println(string + sb.toString());
	}

}
