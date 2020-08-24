package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * knap-sack
 */
public class B12865_평범한배낭 {
	static int N, K, dp[][], c[], w[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken()); K=Integer.parseInt(token.nextToken());
		c=new int[N+1]; w=new int[N+1];
		dp=new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			token = new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(token.nextToken());
			c[i]=Integer.parseInt(token.nextToken());
		}
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=K; j++) {
				if(w[i]>j) dp[i][j]=dp[i-1][j];
				else {
					dp[i][j]=Math.max(dp[i-1][j-w[i]]+c[i], dp[i-1][j]);	
				}
			}
		}
		int ans=0;
		for(int i=1; i<=N; i++) {
			ans=Math.max(dp[i][K], ans);
		}
		System.out.println(ans);

	}

}
