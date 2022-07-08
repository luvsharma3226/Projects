package test;

import java.util.Arrays;
import java.util.HashMap;

public class Program {

	public static void main(String[] args) {

		int array[] = { 4, 4, 1, 3, 1, 5, 4, 3, 6, 4, 16, 5, 9 };

		int a = findUnique(array);
		printArray(array);
		System.out.println(a);
		
		sortArr(array);
	}

	static void sortArr(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int temp = 0;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		for(int i : a) {
			System.out.print(i + "	");
		}
		System.out.println();
	}

	static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}

	private static int findUnique(int[] a) {
		Arrays.sort(a);

		int i = 0;
		while (i < a.length - 1) {
			if (a[i] != a[i + 1]) {
				return a[i];
			}
			i = i + 2;
		}

		return -1;
	}

}
