package BOJ.sds_algo.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *  kanp-sack
 *  
 *  ---- 비용
 *  |
 *  |
 *  앱
 */
public class B7579_앱 {
	static int N,M, cost [], w[], dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken()); M=Integer.parseInt(token.nextToken());
		dp=new int[N+1][10001];
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
		//System.out.println(Arrays.toString(dp[0]));
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=10000; j++) {
				if(cost[i]>j) {
					dp[i][j]=dp[i-1][j];
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-cost[i]]+w[i]);
				}
				if(dp[i][j]>=M) {
					ans=Math.min(ans, j);
				}
			}
			//System.out.println(Arrays.toString(dp[i]));
		}

	}

}