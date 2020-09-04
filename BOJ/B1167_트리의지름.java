package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * DFS + visited
 */
public class B1167_트리의지름 {
	static int N; 
	static ArrayList<Node>[] g;
	static class Node{
		int d,c;

		public Node(int d, int c) {
			super();
			this.d = d;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [d=" + d + ", c=" + c + "]";
		}

	}
	static int[] r;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		g=new ArrayList[N+1]; r=new int[N+1];
		for(int i=0; i<=N; i++) g[i]=new ArrayList<Node>();
		for(int i=1; i<=N; i++) {
			token = new StringTokenizer(br.readLine());
			int s=Integer.parseInt(token.nextToken());
			int d=0,c=0,cnt=g[s].size();
			while((d=Integer.parseInt(token.nextToken()))!=-1) {
				c=Integer.parseInt(token.nextToken());
				/*
				 * if(cnt>0) { cnt--; continue; }
				 */
				g[s].add(new Node(d,c));
				g[d].add(new Node(s,c));
			}
		}
		for(int i=1; i<=N; i++) System.out.println(g[i]);
		visited=new boolean[N+1];
		visited[1]=true;
		dfs(1);//start
		System.out.println(Arrays.toString(r));
		int ans=0;
		for(int i=1; i<=N; i++) {
			ans=Math.max(ans, r[i]);
		}
		System.out.println(ans);
	}
	static boolean[] visited;
	private static int dfs(int v) {
		int[] child=new int[g[v].size()];
		int one=0, two=0;
		for(int i=0; i<g[v].size(); i++) {
			Node t=g[v].get(i);
			if(!visited[t.d]) {
				visited[t.d]=true;
				child[i]=dfs(t.d)+t.c;
				if(child[i]>one) {
					two=one; one=child[i];
				}
				else if(child[i]>two) two=child[i];
			}
		}
		r[v]=one+two;
		return one;
	}

}
