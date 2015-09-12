package ch1;

import java.util.HashMap;

public class Solution04 {
	
	public static void main(String[] args) {
		String str = "taco cat";
		System.out.println(palindromePermutation(str));
	}

	private static boolean palindromePermutation(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (!Character.isAlphabetic(c)) continue;
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		boolean foundOne = false;
		for (Character c : map.keySet()) {
			int count = map.get(c);
			if (count%2 != 0) {
				if (foundOne) return false;
				foundOne = true;
			}
		}
		return true;
	}

}
