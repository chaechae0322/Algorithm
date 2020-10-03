package BOJ;
import java.util.Scanner;
/*
 * DP (knapsack)
 * 
 * 역추적
 * dp값이 다르고 r[y]==p[x]일경우에 유효한값 주의
 */
public class B9252_LCS2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String r=sc.next();
		String p=sc.next();
        		
		if(r.length()>p.length()) {
			String t=r;
			r=p;
			p=t;
		}
        
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
		StringBuilder sb = new StringBuilder();
		x=p.length(); y=r.length();
		int idx=dp[y][x];
		while(y>=0 && x>=0 && idx>0) {
			while(y-1>=0 && dp[y][x]==dp[y-1][x]) y--;
			if(r.charAt(y-1) == p.charAt(x-1)) {
				ans[--idx]=r.charAt(y-1);
				x--; y--;
				if(idx==0) break;
			}else {
				x--;
			}
		}
		
		sb.append(ans, 0, dp[r.length()][p.length()]);
		System.out.println(dp[r.length()][p.length()]);
		if(sb.length()>0)System.out.println(sb.toString());
	}

}
