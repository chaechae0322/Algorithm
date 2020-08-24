package BOJ.sds_algo.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B7579_앱 {
	static int N,M, cost [], w[];
	static long dp [][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken()); M=Integer.parseInt(token.nextToken());
		dp=new long[N+1][N+1][2]; // 0: 비용, 1: 무게
		cost=new int[N+1]; w=new int[N+1];
		token = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			w[i]=Integer.parseInt(token.nextToken());
		}
		token = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			cost[i]=Integer.parseInt(token.nextToken());
		}


		ans=Integer.MAX_VALUE;
		knabsack();
		System.out.println(ans);
	}
	static int ans;
	private static void knabsack() {
		/*
		 * for(int i=0; i<N; i++) { for(int j=0; j<N; j++) { dp[i][j][0]=Long.MAX_VALUE;
		 * } }
		 */
		for(int j=0; j<=N; j++) {
			System.out.print("("+dp[0][j][0]+" "+dp[0][j][1]+")\t");
		}
		System.out.println();
		for(int i=1; i<=N; i++) {
			dp[1][i][0]=cost[i]; dp[1][i][1]=w[i];
			if(dp[1][i][1]>=M) {
				ans=(int) Math.min(ans, dp[1][i][0]);
			}
		}
		for(int j=0; j<=N; j++) {
			System.out.print("("+dp[1][j][0]+" "+dp[1][j][1]+")\t");
		}
		System.out.println();
		for(int i=2; i<=N; i++) {
			for(int j=i; j<=N; j++) {
				if(i==j) {
					dp[i][j][0]=dp[i-1][j-1][0]+cost[j];
					dp[i][j][1]=dp[i-1][j-1][1]+w[j];
				}
				else {
					if(dp[i][j-1][1]-w[j-1]+w[j]> dp[i-1][j-1][1]+w[j]) {
						dp[i][j][0]=dp[i][j-1][0]-cost[j-1]+cost[j];
						dp[i][j][1]=dp[i][j-1][1]-w[j-1]+w[j];
					}else {
						dp[i][j][0]=dp[i-1][j-1][0]+cost[j];
						dp[i][j][1]=dp[i-1][j-1][1]+w[j];
					}
				}
				if(dp[i][j][1]>=M) {
					ans=(int) Math.min(ans, dp[i][j][0]);
				}
			}

			for(int j=0; j<=N; j++) {
				System.out.print("("+dp[i][j][0]+" "+dp[i][j][1]+")\t");
			}
			System.out.println();
		}

	}

}