package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		
		while(row <= n) {
			char ch = 'A';
			int column = 1;
			while(column <= n ) {
				System.out.print(ch);
				column++;
				ch++;
			}
			row++;
			
			System.out.println();
			
		}
	}
}
