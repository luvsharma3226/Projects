package test;

public class Program {

	public static void main(String[] args) {

		int[] sortArr = { -1, 1, 2, 4, 4, 4, 4, 4,4, 4, 5, 5, 6, 6, 7 };
		int size = sortArr.length - 1;
		System.out.println(size);
		int first = firstOccurence(sortArr, size, 4);
		int last = lastOccurence(sortArr, size, 4);
		System.out.println("first = " + first);
		System.out.println("last = " + last);
	}

	private static int firstOccurence(int[] sortArr, int size, int key) {
		int start = 0, end = size - 1;
		int ans = -1;
		int mid = start + (end - start) / 2;
		while (start <= end) {
			if (key == sortArr[mid]) {
				ans = mid;
				end = mid - 1;
			} else if (key > sortArr[mid]) {
				start = mid + 1;
			} else if (key < sortArr[mid]) {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}
		return ans;
	}

	private static int lastOccurence(int[] sortArr, int size, int key) {

		int start = 0, end = size - 1;
		int ans = 0;
		int mid = start + (end - start) / 2;
		while (start <= end) {

			if (key == sortArr[mid]) {
				ans = mid;
				start = mid + 1;
			} else if (key > sortArr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
			mid = start + (end - start) / 2;
		}

		return ans;

	}
}
