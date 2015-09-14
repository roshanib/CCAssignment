
public class Solution03 {

	public static void main(String[] args) {
		String str = "Mr John Smith     ";
		System.out.println(urlIfy(str));
	}

	private static char[] urlIfy(String str) {
		int spaces  = countSpaces(str);
		// Remove trailing spaces
		int i = str.length()-1; 
		while (i >=0 && str.charAt(i) == ' ') {
			i--;
		}
		
		// Allocate required size
		spaces -= (str.length()-i-1);
		int newSize = i + spaces*2 + 1;
		char[] newArray = new char[newSize];
		
		int j = newSize-1;
		for (; i>=0; i--) {
			char c =str.charAt(i);
			
			if (c == ' ') {
				newArray[j] = '0'; j--;
				newArray[j] = '2'; j--;
				newArray[j] = '%'; j--;
			} else {
				newArray[j] = c; j--;
			}
		}
		
		return newArray;
	}

	private static int countSpaces(String str) {
		int count = 0;
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (c == ' ') {
				count++;
			}
		}
		return count;
	}


}
