package test;

public class Program {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter a number : ");
		int[] input = { 2, 1, 4, 6, 5, 8, 9, 1, 3, 80 };

		int result = sumOfAllEvenNumbers(input);
		System.out.println(result);
	}

	private static int sumOfAllEvenNumbers(int[] input) {
		int i = 0;
		int sum = 0;
		while (i < input.length) {
			if (input[i] % 2 == 0)
				sum = sum + input[i];
			i++;
		}
		return sum;
	}

}
