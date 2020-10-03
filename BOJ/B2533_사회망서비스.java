package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * DFS
 * 
 */
public class B2533_사회망서비스 {
	static int n, cnt, check[]; 
	static ArrayList<Integer>[] g;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		n=Integer.parseInt(br.readLine());
		g=new ArrayList[n+1]; visited=new boolean[n+1]; check=new int[n+1];
		for(int i=0; i<=n; i++) g[i]=new ArrayList<Integer>();
		for(int i=0; i<n-1; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			g[a].add(b); g[b].add(a);
		}
		visited[1]=true; //임의의 루트
		dfs(1,0);
		System.out.println(cnt);
	}
	private static void dfs(int pos, int p) {
		int res=0;
		for(int i=0; i<g[pos].size(); i++) {
			if(!visited[g[pos].get(i)]) {
				visited[g[pos].get(i)]=true;
				dfs(g[pos].get(i), pos);
				res += 1;
				if(check[g[pos].get(i)]==1) res -= 1;
			}
		}
		if(res>0) {
			check[pos]=1; cnt++;
		}
	}

}
