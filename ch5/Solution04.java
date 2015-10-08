package ch5;

public class Solution04 {

	public static int getNext(int n) {
		int num = n;
		int c0 = 0;
		int c1 = 0;
		while (((num & 1) == 0) && (num != 0)) {
			c0++;
			num /= 2;
		}
		
		while ((num & 1) == 1) {
			c1++;
			num /= 2;
		}
		if (c0 + c1 == 31 || c0 + c1 == 0) {
			return -1;
		}
		
		return n + (1 << c0) + (1 << (c1 - 1)) - 1;
	}
	
	public static int getPrevArith(int n) {
		int num = n;
		int c0 = 0;
		int c1 = 0;
		while (((num & 1) == 1) && (num != 0)) {
			c1++;
			num /= 2;
		}
		
		if (num == 0) { 
			return -1;
		}
		
		while ((num & 1) == 0 && (num != 0)) {
			c0++;
			num /= 2;
		}

		return n - (1 << c1) - (1 << (c0 - 1)) + 1;		
	}	
	
	public static void main(String[] args) {
		int i = 4;
		int p1 = getPrevArith(i);
		int n1 = getNext(i);
		System.out.println("i: " + i + " prev: " + p1 + " next: " + n1);
		i = 234;
		p1 = getPrevArith(i);
		n1 = getNext(i);
		System.out.println("i: " + i + " prev: " + p1 + " next: " + n1);
	}

}
