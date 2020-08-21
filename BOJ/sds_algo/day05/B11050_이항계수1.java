package BOJ.sds_algo.day05;

import java.util.Scanner;

public class B11050_이항계수1 {
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); int K=sc.nextInt();
		dp=new long[N+1][N+1];
		dp[0][0]=1; dp[1][0]=1; dp[1][1]=1;
		combi(N,K);
		System.out.println(dp[N][K]);
	}
	private static long combi(int n, int k) {
		if(dp[n][k]!=0) return dp[n][k];
		if(k==0||k==n) {
			dp[n][k]=1;
			return dp[n][k];
		}
		dp[n][k]=combi(n-1,k-1)+combi(n-1,k);
		return dp[n][k];
	}
	

}
