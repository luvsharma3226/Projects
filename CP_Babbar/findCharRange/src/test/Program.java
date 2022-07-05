package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a character : ");
		char input = sc.next().charAt(0);

		findCharRange(input);
		sc.close();

	}

	private static void findCharRange(char ch) {
		if (ch > 'a' && ch < 'z') {
			System.out.println("Letter is a LOWERCASE");
		}
		else if(ch > 'A' && ch < 'Z') {
			System.out.println("Letter is a UPPERCASE");
		}
		else {
			System.out.println("Letter is a NUMERIC");
		}


//		System.out.println(ch);
	}
}
