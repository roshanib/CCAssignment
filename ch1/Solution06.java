public class Solution06 {

	public static void main(String[] args) {
		String str = "aabcccccaaa";
		System.out.println(compress(str));
	}

	private static String compress(String str) {
		StringBuffer sb = new StringBuffer();
		
		int count = 1;
		char prev = str.charAt(0);
		for (int i=1; i<str.length(); i++) {
			if (str.charAt(i) == prev) {
				count++;
			} else {
				// Found total count of consecutive characters
				// add to compressed string
				sb.append(str.charAt(i-1));
				sb.append(String.valueOf(count));
				prev = str.charAt(i);
				count = 1;
			}
		}
		
		// Add the last character and count
		sb.append(prev);
		sb.append(String.valueOf(count));
		return sb.toString();
	}
}
