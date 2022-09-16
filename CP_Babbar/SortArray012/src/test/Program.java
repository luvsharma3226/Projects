package test;

public class Program {

	public static void swapNum(int a[], int s, int e) {
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
	}

	public static void main(String[] args) {

		int array[] = { 0, 2, 1, 2, 0, 1, 2 };
		int start = 0, end = array.length - 1;

		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}
}
