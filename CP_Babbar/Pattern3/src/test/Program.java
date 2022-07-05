package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of n: ");
		int n = sc.nextInt();
		int i = 1;
		while(i <= n) {
			int j = 1;
			int value = i ;
			while(j <= i) {
				System.out.print(value++);
				j++;
			}
			i++;
			System.out.println();
			
		}
	}
}
