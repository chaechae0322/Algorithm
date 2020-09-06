package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B16562_친구비 {
	static int N,M,k,c[];
	static ArrayList<Integer>[] g;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		k=Integer.parseInt(token.nextToken());
		c=new int[N+1]; g=new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			g[i]=new ArrayList<>();
		}
		token = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			c[i]=Integer.parseInt(token.nextToken());
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			g[a].add(b); g[b].add(a);
		}
		visited=new boolean[N+1];
		int ans=0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				ans+=dfs(i);
				if(ans>k) {
					System.out.println("Oh no");
					return;
				}
			}
		}
		System.out.println(ans);
	}
	private static int dfs(int v) {
		int res = c[v];
		for(int i=0; i<g[v].size(); i++) {
			int t=g[v].get(i);
			if(visited[t]) continue;
			visited[t]=true;
			res=Math.min(res, dfs(t));
		}
		return res;
	}
	static boolean[] visited;
}
