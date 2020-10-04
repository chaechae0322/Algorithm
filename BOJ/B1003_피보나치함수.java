package BOJ;

import java.util.Arrays;
import java.util.Scanner;
/*
 * DP
 */
public class B1003_피보나치함수 {
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		dp=new long[41][2];
		dp[0][0]=1; dp[1][1]=1;
		for(int t=0; t<tc; t++) {
			int n=sc.nextInt();
			fibo(n);
			System.out.println(dp[n][0]+" "+dp[n][1]);
		}
	}
	
	private static void fibo(int n) {
		if(dp[n][0]!=0||dp[n][1]!=0) return;
		else {
			fibo(n-1);
			fibo(n-2);
			dp[n][0]+=(dp[n-1][0]+dp[n-2][0]); dp[n][1]+=(dp[n-1][1]+dp[n-2][1]);
		}
	}

}
