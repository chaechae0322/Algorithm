package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1509_팰린드롬분할 {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String input = br.readLine();
	int n = input.length();

	int[] dp=new int[n]; // 
	int[][] pel=new int[n][n];
	for(int i=0; i<n; i++) {
		pel[i][i]=1;
	}
		
	for(int i=1; i<n; i++) {
		System.out.println(input.charAt(i)+" 시작");
		for(int j=i-1; j>=0; j--) { // 팰린드롬 검사
			if(pel[i-1][j]==1) {
				System.out.println("펠린드롬");
				int side = (i-1)-(i-j);
				
				System.out.println("side:"+side);
				if(side>=0 && input.charAt(i)==input.charAt(side)) {
					pel[i][side] = 1;
				}
			}
		}
		
		for(int j=i-1; j>=0; j--) {
			if(input.charAt(i)!=input.charAt(j)) {
				break;
			}
			pel[i][j]=1;
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(Arrays.toString(pel[i]));
		}
		
		
		dp[0]=1;
		for(int i=1; i<n; i++) {
			System.out.println(input.charAt(i)+" dp 시작");
			
			for(int j=i-1; j>=0; j--) { // 0 ~ i-1
				if(pel[i][j]==1) {
					System.out.println("pelindrom j:"+j);
					dp[i]= Math.min(dp[i-1]+1, (j-1<0?0:dp[j-1])+1); 
					
				}
			}
			if(dp[i]==0) dp[i]=dp[i-1]+1;
			System.out.println(Arrays.toString(dp));
		}
		//System.out.println("dp check");
		System.out.println(dp[n-1]);
	}


}
