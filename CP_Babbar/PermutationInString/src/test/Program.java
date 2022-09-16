package test;

import java.util.Arrays;

public class Program {

	public static boolean checkInclusion(String s1, String s2) {

		// Edge cases
		if (s1.length() > s2.length() || s2.length() == 0) {
			return false;
		}
		if (s1.length() == 0)
			return true;
		int x = s1.length(), y = s2.length();
		int array1[] = new int[26];
		int array2[] = new int[26];

		for (int i = 0; i < x; i++) {
			// System.out.println(++array1[s1.charAt(i) -'a']);
			array1[s1.charAt(i) - 'a']++;
		}
		for (int j = 0; j < y; j++) {
			System.out.println(s2.charAt(j)-'a');
			array2[s2.charAt(j) - 'a']++;
		}

		for (int i = x; i < y; i++) {
			if (Arrays.equals(array1, array2))
				return true;

		
			// remove the first element
			array2[s2.charAt(i - x) - 'a']--;

			// slide the window
			// add the next element to array2
			array2[s2.charAt(i) - 'a']++;

		}
		if (Arrays.equals(array1, array2))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidbaooo";
		boolean res = checkInclusion(s1, s2);
		System.out.println(res);
		
	}

}
