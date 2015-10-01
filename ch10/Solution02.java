package ch10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution02 {

	public static void main(String[] args) {
		String[] array = { "pace", "zoo", "cpae", "rosh", "ozo", "shor" };

		for (String s : sortAnagrams(array)) {
			System.out.print(s + " ");
		}
	}

	private static ArrayList<String> sortAnagrams(String[] array) {
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String a : array) {
			char[] chars = a.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);

			if (map.containsKey(sorted)) {
				map.get(sorted).add(a);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(a);
				map.put(sorted, list);
			}
		}

		ArrayList<String> result = new ArrayList<>();
		for (String key : map.keySet()) {
			result.addAll(map.get(key));
		}
		return result;
	}

}
