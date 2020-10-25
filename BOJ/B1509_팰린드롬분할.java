package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1509_팰린드롬분할 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int m = input.length();
		
		int[] p = new int[m];
		int[] dp = new int[m];

		int idx=1;
		p[0]=1;
		
		while(idx<m) {
			if(idx-p[idx-1]-1>=0 && input.charAt(idx-p[idx-1]-1)==input.charAt(idx)) {
				// 팰린드롬
				p[idx]+=(p[idx-1]+2);
			}else {
				int tmp=1;
				while(tmp<=idx && input.charAt(idx-tmp)==input.charAt(idx)) {
					tmp++;
				}
				p[idx]=tmp;
			}
			idx++;
		}
		
		// 팰린드롬 체크
		System.out.println(Arrays.toString(p));
		for(int i=0; i<m; i++) {
			if(p[i]>1) {
				System.out.println(input.substring(i-p[i]+1,i+1));
			}
		}
		dp[0]=p[0];
		for(int i=1; i<m; i++) {
			if(i-p[i]<0) {
				dp[i]=Math.min(1, dp[i-1]+1);
			}else {
				dp[i]=Math.min(dp[i-p[i]]+1, dp[i-1]+1);
			}
		}
		System.out.println(dp[m-1]);
	}

}
