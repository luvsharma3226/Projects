package test;

import java.util.Scanner;

public class Program {

	public static int min(long x, long y) {
		if(x>y)
			return (int)y;
		else
			return (int)x;
		
	}
	
	
	public static int nCrMod(int n, int r){
		if(n<r) return 0;
		if((n-r)<r) r = n-r;
		
		int mod = 1000000007;
		int[] dp = new int[r+1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = min(r,i); j > 0; j--) {
				dp[j] = (dp[j]+dp[j-1])%mod;
			}
		}
		
		return dp[r];
	}
	
	public static long factorial(long val) {
		long ans = 1;
		for (int i = 1; i <= val; i++) {
			ans = ans * i;
		}
		System.out.println("fact of "+val+"= "+ans);
		return ans;
	}

	public static long nCr(long n, long r) {
		long ans = (factorial(n) / (factorial(n - r) * factorial(r)));
		System.out.println("ncr"+n +","+r+"= "+ans);		
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the value of n : ");
		long n = sc.nextInt();
		System.out.print("Enter the value of r : ");
		long r = sc.nextInt();
//		int fa = factorial(n);
		long result = nCr(n, r);
		System.out.println("Result : " + result);
	}

}
