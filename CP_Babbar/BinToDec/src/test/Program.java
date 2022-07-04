package test;

import java.util.Scanner;

public class Program {

	public static void DecimalTOBinary() {

		System.out.print("Enter a number : ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int temp = number;

		int ans = 0;
		int i = 0;
		while (temp != 0) {
//			System.out.println(temp + "   ");

			int bit = temp & 1;
//			System.out.print(bit + "   ");
			temp = temp >> 1;

			ans = (int) ((bit * Math.pow(10, i)) + ans);
			i++;
		}
		System.out.println("Binary of " + number + " is " + ans);
	}

	public static int menuList() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your choice : ");
		System.out.println("0. Exit. ");
		System.out.println("1. Decimal To Binary. ");
		System.out.println("2. Binary to Decimal. ");

		return sc.nextInt();

	}

	public static void main(String[] args) {

		while (true) {
			int choice = menuList();
			switch (choice) {
			case 0: {
				break;
			}
			case 1: {
				DecimalTOBinary();
				break;
			}

			}

		}
	}
}
