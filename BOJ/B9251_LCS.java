package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * DP
 * kanp-sack 비스무리
 */
public class B9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sn=br.readLine(), sm=br.readLine();
		int n=sn.length(), m=sm.length();
		int[][] dp=new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			char ref=sn.charAt(i-1);
			for(int j=1; j<=m; j++) {
				int t=(ref==sm.charAt(j-1))?1:0;
				
				if(t==1) {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j-1]+t);
				}else {
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
				}

			}
		}
		int ans=0;
		for(int i=1; i<=n; i++) {
			ans=Math.max(ans, dp[i][m]);
		}
		System.out.println(ans);
	}

}
