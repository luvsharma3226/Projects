package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		int val = 1;
		while (row <= n) {
			int space = 1;
			//printing space
			while(space <= n-row) {
				System.out.print(" ");
				space ++;
			}
			int col=1;
			int val1 = 1;
			// second triangle
			while(col <= row) {
				System.out.print(val1++);
				col++;
			}
			
			int third =1;
			int val2 = row-1;
			while(third < row ) {
				System.out.print(val2--);
				third++;
			}
			row++;
			System.out.println();
		}

	}
}
