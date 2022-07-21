package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int row = 1;
		
		while (row <= n) {
			
			int first = 1;
			int v1 = 1;
			while (first <= n - row+1) {
				System.out.print(v1++);
				first++;
			}
			int second = 1;
			while(second < row) {
				System.out.print("*");
				second ++;
			}
			
			int third = 1;
			while(third <= row-1) {
				System.out.print("*");
				third++;
			}
			
			int fourth = 1;
			int v2 = n-row-fourth+2;
			while (fourth <= n - row+1) {
				System.out.print(v2--);
				fourth++;
			}
			row++;
			System.out.println();
		}

	}
}
