package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * DFS
 * 트리의 지름 v1, v2
 * v1을 제외하고 트리의지름 d1
 * v2를 제외하고 트리의지름 d2
 * max(d1,d2)가 두번째 트리의 지름 
 */
public class B19581_두번째트리의지름 {
	static int N;
	static Node[] r;
	static ArrayList<Node>[] g;
	static class Node{
		int d, l, r;
		long c;

		Node(int d, long c) {
			super();
			this.d = d;
			this.c = c;
		}

		Node(int d, long c, int l, int r) {
			super();
			this.d = d;
			this.c = c;
			this.l = l;
			this.r = r;
		}

		@Override
		public String toString() {
			return "Node [d=" + d + ", c=" + c + ", l=" + l + ", r=" + r + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		g=new ArrayList[N+1]; r=new Node[N+1];
		for(int i=0; i<=N; i++) g[i]=new ArrayList<>();
		String line="";
		while((line=br.readLine())!=null && line.length()>0) {
			token = new StringTokenizer(line);
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			g[a].add(new Node(b,c));
			g[b].add(new Node(a,c));
		}
		visited=new boolean[N+1];
		visited[1]=true;
		dfs(1);
		int maxv=0;
		r[0]=new Node(0,0);
		for(int i=1; i<=N; i++) {
			System.out.println(r[i]);
			if(r[i].c>r[maxv].c) {
				maxv=i;
			}
		}
		long ans=0;
		int v1=r[maxv].l, v2=r[maxv].r;
		Arrays.fill(visited, false);
		visited[v1]=true;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i);
				break;
			}
		}
		for(int i=1; i<=N; i++) {
			if(r[i].c>ans) {
				ans=r[i].c;
			}
		}
		Arrays.fill(visited, false);
		visited[v2]=true; 
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(i);
				break;
			}
		}
		for(int i=1; i<=N; i++) {
			if(r[i].c>ans) {
				ans=r[i].c;
			}
		}
		System.out.println(ans);
	}
	static boolean[] visited;
	private static Node dfs(int v) {
		long one=0, two=0; int onev=0, twov=0;
		Node res=null;
		for(int i=0; i<g[v].size(); i++) {
			Node tmp=g[v].get(i);
			if(visited[tmp.d]) continue;
			visited[tmp.d]=true;
			res=dfs(tmp.d);
			if(res.c+tmp.c>one) {
				two=one;
				twov=onev;
				one=res.c+tmp.c;
				onev=res.d;
			}else if(res.c+tmp.c>two) {
				two=res.c+tmp.c; twov=res.d;
			}
		}
		r[v]=new Node(v, one+two,onev, twov==0?v:twov);
		if(one==0) {
			return new Node(v,one,0,0);
		}else {
			return new Node(onev, one, 0,0);
		}
		
	}
	

}
