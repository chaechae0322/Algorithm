package BOJ.sds_algo.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010_다리놓기 {
	
	static long[][] dp=new long[31][31];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int T=Integer.parseInt(token.nextToken());
		
		
		dp[0][0]=1; dp[1][0]=1; dp[1][1]=1;
		for(int i=2; i<=30; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0||j==i) {
					dp[i][j]=1;
					continue;
				}
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				
			}
		}
		
		for(int t=0; t<T; t++) {
			token = new StringTokenizer(br.readLine());
			int N=Integer.parseInt(token.nextToken());
			int M=Integer.parseInt(token.nextToken());
			
			//System.out.println(dp[M][N]);
			System.out.println(combi(M,N));
		}
	}
	public static long combi(int n, int k) {
		if(dp[n][k]!=0) return dp[n][k];
		
		if(k==0 || k==n) {
			dp[n][k]=1;
			return 1;
		}
		
		dp[n][k] = combi(n-1,k-1)+combi(n-1,k);
		return dp[n][k];
	}
}
