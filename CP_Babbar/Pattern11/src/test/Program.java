package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		
		while(row <= n) {
			char temp = 'A';
			int column = 1;
			
			while(column <= row ) {
				char t = (char) (temp+row-1);
				System.out.print(t);
				column++;
				temp++;
			}
			row++;
			
			System.out.println();
			
		}
	}
}
