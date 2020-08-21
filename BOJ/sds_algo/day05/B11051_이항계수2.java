package BOJ.sds_algo.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11051_이항계수2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N=Integer.parseInt(input[0]), K=Integer.parseInt(input[1]);
		
		long[][] dp=new long[N+1][N+1];
		dp[0][0]=1; dp[1][0]=1; dp[1][1]=1;
		for(int i=2; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==N) {
					dp[i][j]=1;
					continue;
				}
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j])%10007L;
			}
		}
		//for( int i=0; i<=N ;i++)
		//	System.out.println(Arrays.toString(dp[i]));
		
		System.out.println(dp[N][K]);
	}

}
