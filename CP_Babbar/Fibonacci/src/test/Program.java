package test;

import java.util.Scanner;

public class Program {

	public static int fibonacci(int n) {
		int fib[] = new int[n];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < n; i++) {
			fib[i] = fib[i-2]+ fib[i-1];
		}
		if(fib[n-1] < Integer.MAX_VALUE)
		return fib[n-1];
		
		return 0;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of n : ");
		int n = sc.nextInt();
		
		int result = fibonacci(n);
		System.out.println("Result : " + result);
	}
}
