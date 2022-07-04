package test;

public class Program {

	public static void main(String[] args) {

		int array[] = { 2, 3, 6, 4, 5, 7, 9, 1, 34, 235, 565, 341 };

		reverseArray(array);
		printArray(array);
	}

	static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ "  ");
		}
		System.out.println();
	}

	private static void reverseArray(int[] a) {
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;

			start++;
			end--;
		}

	}

}
