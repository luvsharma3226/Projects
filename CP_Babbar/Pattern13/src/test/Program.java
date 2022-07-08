package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();

		int row = 1;
		while(row <= n) {
			
			int space = 1;
			while(space <= n -row) {
				System.out.print(" ");
				space++;
			}
			
			int col = 1;
			while(col <= row) {
				System.out.print("#");
				col++;
			}
			row++;
			System.out.println();
		}
		
	}
}
