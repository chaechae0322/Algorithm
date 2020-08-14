package sds_algorithm.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1256_사전 {
	static int N,M;
	static Long K;
	static long[][] dp;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		K=Long.parseLong(token.nextToken());

		dp=new long[N+M+1][N+M+1];
		dp[0][0]=1; dp[1][0]=1; dp[1][1]=1;

		combi(N+M, N);
		if(K>dp[N+M][N]) {
			System.out.println(-1);
			return;
		}
		
		//System.out.println(min);
		
		sb= new StringBuilder();
		solve(K, N+M, N, 0, 0);
		
		System.out.println(sb.toString());
	}

	private static void solve(long t, int n, int k, int acnt, int zcnt) {
		//System.out.println(t+" "+n+" "+k+" "+cnt+" "+dp[n][k]);
		//System.out.println(sb.toString());
		
		if(acnt+zcnt==N+M) return;
		
		if(k==0) {
			if(acnt<N) {
				sb.append('a');
				solve(t, n, k, acnt+1, zcnt);
			}else {
				sb.append('z');
				solve(t, n, k, acnt, zcnt+1);
			}
			return;
		}
		
		if(t<=dp[n-1][k-1]) {
			//System.out.println("작다");
			sb.append('a');
			solve(t, n-1, k-1, acnt+1, zcnt);
		}else {
			//System.out.println("크다");
			sb.append('z');
			solve(t-dp[n-1][k-1], n-1, k, acnt, zcnt+1);
		}
	}
	static long min=0;
	public static long combi(int n, int k) {
		if(dp[n][k]!=0) {
			return dp[n][k];
		}

		if(k==0||k==n) {
			dp[n][k]=1;
			return dp[n][k];
		}

		dp[n][k]=(long) Math.min(combi(n-1, k-1)+combi(n-1,k), 10e9);
		min=Math.min(min, dp[n][k]);
		return dp[n][k];
	}
}
