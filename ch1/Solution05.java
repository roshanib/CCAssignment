
public class Solution05 {

	public static void main(String[] args) {
		String str = "pale";
		String str1 = "ple";
		
		System.out.println(oneDistance(str, str1));
	}

	private static boolean oneDistance(String str, String str1) {
		int length1 = str.length();
		int length2 = str1.length();
		
		if (length1 == length2) {
			// Expect only one replace for same length strings
			boolean foundDiff = false;
			for (int i=0; i<length1; i++) {
				if (str.charAt(i) != str1.charAt(i)) {
					if (foundDiff) return false;
					foundDiff = true;
				}
			}
		} else {
			// Figure out the big and small string
			String big, small;
			if (length1 > length2) {
				big = str; small = str1;
			} else {
				big = str1; small = str;
			}
			
			// Expect big to need only one delete to match small
			boolean foundDiff = false;
			for (int i=0, j=0; i<big.length(); i++, j++) {
				if (big.charAt(i) != small.charAt(j)) {
					if (foundDiff) return false;
					j--;
					foundDiff = true;
				}
			}
		}
		return true;
	}

}
