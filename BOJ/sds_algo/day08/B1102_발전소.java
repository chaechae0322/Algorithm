package BOJ.sds_algo.day08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 비트필드를 이용한 DP 
 */
public class B1102_발전소 {
	static int N,P;
	static int cost[][], dp[], visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		cost=new int[N][N]; dp=new int[1024*64]; visited=new int[1024*64];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) 
				cost[i][j]=Integer.parseInt(token.nextToken());
		}
		char[] in=br.readLine().toCharArray();
		int s=0, p=(int) Math.pow(2, N-1);
		int cnt=0;
		for(int i=0; i<N; i++) {
			if(in[i]=='Y') {
				s+=p;
				cnt++;
			}
			p>>=1;
		}
		P=Integer.parseInt(br.readLine());
		if(P<=cnt) {
			System.out.println(0);
			return;
		}
		if(cnt==0) {
			System.out.println(-1);
			return;
		}
		dfs(s, 0, cnt);
		System.out.println(dp[s]);
		
	}
	private static int dfs(int s, int c, int cnt) {
		if(cnt==P) return 0;
		if(visited[s]!=0) return dp[s];
		 
		visited[s]=1;
		int res=Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			if((s&(1<<i))==0) { // i번째 0
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if((s&(1<<j))>0) { // j번재 1
						res=Math.min(res, dfs(s+(1<<i), c+cost[N-1-j][N-1-i], cnt+1)+cost[N-1-j][N-1-i]);
					}
				}
			}
		}
		dp[s]=res;
		return dp[s];
	}

}
