package BOJ;

import java.util.Scanner;

public class B2193_이천수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		long[] dp=new long[n+1];
		dp[1]=1; if(n>1) dp[2]=1;
		for(int i=3; i<=n; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(dp[n]);
	}

}
