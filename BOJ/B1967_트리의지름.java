package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *  Tree
 *  DFS
 */
public class B1967_트리의지름 {
	static int N, res[];
	static ArrayList<Node>[] g;
	static class Node{
		int dst,w;

		public Node(int dst, int w) {
			super();
			this.dst = dst;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [dst=" + dst + ", w=" + w + "]";
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		g=new ArrayList[N+1]; res=new int[N+1];
		for(int i=0; i<=N; i++) g[i]=new ArrayList<>();
		for(int i=0; i<N-1; i++) {
			token = new StringTokenizer(br.readLine());
			int p=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			int w=Integer.parseInt(token.nextToken());
			g[p].add(new Node(c, w));
		}
		// root 1
		dfs(1);
		int ans=0;
		for(int i=1; i<=N; i++) {
			ans=Math.max(res[i], ans);
		}
		System.out.println(ans);
	}
	private static int dfs(int cu) {
		int r=0, max=0, sec=-1;
		int[] child=new int[g[cu].size()];
		for(int i=0; i<g[cu].size(); i++) {
			child[i]=dfs(g[cu].get(i).dst)+ g[cu].get(i).w; 
			if(child[i]>max) {
				sec=max;
				max=child[i];
			}else if(child[i]>sec) {
				sec=child[i];
			}
		}
		res[cu]=max+sec;
		return max;
	}
}
