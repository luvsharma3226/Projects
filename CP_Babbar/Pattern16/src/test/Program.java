package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		
		while(row < n) {
			int col = 1;
			int space = n;
			
			while(space > row) {
				System.out.print(" ");
				space--;
			}
			
			while(col <= row) {
				System.out.print(row);
				col++;
			}
			row++;
			System.out.println();
		}
	}
}
