package sds_algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748_피보나치수2 {
	static long[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		dp=new long[n+1];
		dp[0]=0; 
		if(n>=1) {dp[1]=1;}
		if(n>=2) {dp[2]=1;}
		for(int i=3; i<=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
