package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class B9252_LCS2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String r=sc.next();
		String p=sc.next();
		int x=0,y=0, dp[][]=new int[r.length()+1][p.length()+1];
		char[] ans=new char[1001];
		for(int i=1; i<=r.length(); i++) { // 
			char t=r.charAt(i-1);
			for(int j=1; j<=p.length(); j++) {
				if(t==p.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-1]+1);
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		System.out.println("check");
		for(int i=0; i<=r.length(); i++) {
			for(int j=0; j<=p.length(); j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		StringBuilder sb = new StringBuilder();
		x=p.length(); y=r.length();
		int idx=dp[y][x];
		while(y>=0 && x>=0 && idx>0) {
			while(y-1>=0 && dp[y][x]==dp[y-1][x]) y--;
			//System.out.println("x:"+x+" y:"+y+" char:"+r.charAt(y-1));
			
			ans[--idx]=r.charAt(y-1);
			x--; y--;
			if(idx==0)break;
			
		}
		sb.append(ans, 0, dp[r.length()][p.length()]);
		System.out.println(dp[r.length()][p.length()]);
		if(sb.length()>0)System.out.println(sb.toString());
	}

}
