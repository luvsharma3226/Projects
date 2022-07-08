package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		int val = 1;
		while(row <= n) {
			
			int space = 1;
			while(space <= n - row) {
				System.out.print(" ");
//				System.out.print(space +" " + (n-row));
				space++;
			}
			
			int col = 1;
			
			while(col <= row) {
				System.out.print(val++);
				col++;
			}
			row ++;
			System.out.println();
			
		}
		
	}
}
