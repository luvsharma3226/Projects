package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;

		while (row <= n) {
			int col = 1;
			
			int space = 1;
			while(space < row) {
				System.out.print(" ");
				space++;
			}
			
			while(col <= n -row+1) {
				System.out.print("*");
				col++;
			}
			row++;
			System.out.println();
		}
	}
}
