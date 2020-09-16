package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class B2133_타일채우기 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		if(n%2==1) {
			System.out.println(0);
			return;
		}
		long[] dp=new long[n+1];
		dp[0]=1; dp[2]=3;
		for(int i=4; i<=n; i+=2) {
			for(int j=2; j<=i-2; j+=2) {
				if(j==2) {
					dp[i]+=dp[i-j]*3;
				}else {
					dp[i]+=dp[i-j]*2;
				}
			}
			dp[i]+=2;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}
