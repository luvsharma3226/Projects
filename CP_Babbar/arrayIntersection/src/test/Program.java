package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	static void printArray(List<Integer> a) {
		for (Integer i : a) {
			System.out.print(i+"  ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 5, 6, 8, 3 };
		int b[] = { 10, 2, 45, 54, 63, 8, 3 };

		
		List<Integer> result = arrayIntersectionBySort(a, b);
		List<Integer> result2 = arrayIntersection(a, b);
		printArray(result);
		printArray(result2);
	}

	private static List<Integer> arrayIntersection(int[] a, int[] b) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					list.add(a[i]);
				}
			}
		}
		return list;

	}

	private static List<Integer> arrayIntersectionBySort(int[] a, int[] b) {
		ArrayList<Integer> list = new ArrayList<>();
		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] == b[j]) {
				list.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]) {
				i++;
			} else if (a[i] > b[j]) {

				j++;
			}
		}
		return list;

	}

}
