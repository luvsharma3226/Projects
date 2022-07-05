package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		while(row <= n) {
			int column = 1;
			int val = row;
			while(column <= row ) {
				System.out.print(val--);
				column++;
			}
			row++;
			System.out.println();
			
		}
	}
}
