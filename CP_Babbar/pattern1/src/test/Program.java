package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the value of n = ");
		int n = sc.nextInt();

		int i = 1;
		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print("*");
				j++;
			}
			i++;
			System.out.println();
		}

	}

}