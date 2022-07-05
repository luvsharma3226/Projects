package test;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		System.out.println("Enter a number: ");
		int n = sc.nextInt();
		
		 System.out.println(primeNumber(n));
		}
	}

	private static String primeNumber(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if(n % i == 0)
				return "Not Prime";
		}
		return "Prime";
		
	}
}
