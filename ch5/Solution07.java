package ch5;

public class Solution07 {
	public static int swapOddEvenBits(int x) { 
		return ( ((x & 0xaaaaaaaa) >>> 1) | ((x & 0x55555555) << 1) ); 
	}
	
	public static void main(String[] args) {
		int a = 1234;
		int b = swapOddEvenBits(a);
		Solution01.printNumberBinary(a, "a : ");
		Solution01.printNumberBinary(b, "Swapped a :");
	}
		

}
