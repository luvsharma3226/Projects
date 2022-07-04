package test;

public class Program {

	public static void main(String[] args) {

		int array[] = { 2, 3, 6, 4, 5, 7, 8 };

		swapAlternate(array);
		printArray(array);
	}

	static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ "  ");
		}
		System.out.println();
	}

	private static void swapAlternate(int[] a) {
		int i = 0;
		
		while (i < a.length-1) {
			int temp = a[i];
			a[i] = a[i+1];
			a[i+1] = temp;

			i= i+2;
		}

	}

}
