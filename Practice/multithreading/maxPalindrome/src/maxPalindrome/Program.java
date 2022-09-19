package maxPalindrome;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static int isPalindrome(String str) {
		for (int i = 0, j = str.length() - 1; i < str.length() && j > 0; i++, j--) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else
				return 0;
		}

		return str.length();
	}

	public static void reversePalindrome(String str) {
		StringBuilder s = new StringBuilder(str);
		StringBuilder rev = s.reverse();
		rev.toString();

		if (str.equals(rev.toString())) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not a palindrome");
		}
	}

	public static List<String> maxSubString(String str) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i <= str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
//				System.out.println(str.substring(i,j));
				list.add(str.substring(i, j));

//				System.out.println(i +"   "+j);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a string : ");
		String str = sc.nextLine();
		String res = null;
		int maxCount = Integer.MIN_VALUE;
		List<String> maxSubString = Program.maxSubString(str);
		for (String string : maxSubString) {
			if (maxCount < Program.isPalindrome(string)) {
				res = string;
				maxCount = string.length();
			}
		}
		System.out.println(res);

//		Program.reversePalindrome(str);
	}

}
