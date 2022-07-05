package test;

import java.util.Scanner;

public class Program {
	
	public static void minMax(int arr[], int size) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if(min > arr[i] ){
				min = arr[i];
			}
			else if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("Max = " + max);
		System.out.println("Min = " + min);
	}
	
	
	public static int minimum(int arr[], int size) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if(min > arr[i]){
				min = arr[i];
			}
		}
		return min;
	}

	public static int maximum(int arr[], int size) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if(max < arr[i]){
				max = arr[i];
			}
		}
		return max;
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int array[] = {12,4,2,6,8,100,34,0,-23};
		int size = array.length;
//		System.out.println("Enter the size of array : ");
//		int size = sc.nextInt();
//		int array[] = new int[size];
//		System.out.println("Enter the elements of array : ");
//		for(int i = 0; i < size; i++) {
//			array[i] = sc.nextInt();
//		}
		int res = minimum(array, size);
		int max = maximum(array, size);
		minMax(array, size);
		System.out.println("Minimum : "+res);
		System.out.println("Maximum : "+max);
	}
}