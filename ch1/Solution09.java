public class Solution09 {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "lewaterbott";
		
		System.out.println(isRotation(s1, s2));
	}

	private static boolean isRotation(String s1, String s2) {
		// check if {s1 + s1} contains s2
		return isSubstring(s1.concat(s1), s2);
	}

	private static boolean isSubstring(String concat, String s2) {
		return concat.contains(s2);
	}

}
