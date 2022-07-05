package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		System.out.println("Enter a number : ");
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> bin = new ArrayList<Integer>();
		int num = sc.nextInt();
		
		while(num != 0) {
			int digit = num % 2;
			bin.add(digit);
			num = num /2;
		}
		Collections.reverse(bin);
		
//		for (int i = 0; i < bin.size(); i++) {
//			
//			if(bin.get(i)== 0)
//				bin.set(i, 1);
//			else
//				bin.set(i, 0);
//		}
		
		int ans = 0;
		for (int i = 0; i < bin.size(); i++) {
			ans = (int) (bin.get(i) * Math.pow(2, i) +ans); 
		}
		
		System.out.println("Ans = "+ans);
		for (Integer integer : bin) {
			System.out.print(integer);
		}
		
		
	}

}
