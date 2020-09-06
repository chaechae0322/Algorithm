package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19581_두번째트리의지름 {
	static int N;
	static long r[][];
	static ArrayList<Node>[] g;
	static class Node{
		int d, c;

		public Node(int d, int c) {
			super();
			this.d = d;
			this.c = c;
		}

		public int getC() {
			return c;
		}

		public void setC(int c) {
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [d=" + d + ", c=" + c + "]";
		}
		
	}
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		r=new long[N+1][2]; g=new ArrayList[N+1]; visited=new boolean[N+1];
		for(int i=0; i<=N; i++) g[i]=new ArrayList<Node>();
		String line="";
		while((line=br.readLine())!=null && line.length()>0) {
			//System.out.println("ee");
			token = new StringTokenizer(line);
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			g[a].add(new Node(b, c));
			g[b].add(new Node(a,c));
		}
		for(int i=1; i<=N; i++) System.out.println(g[i]);
		
		visited[1]=true;
		dfs(1);
		long one=0, two=0;
		for(int i=1; i<=N; i++) {
			for(int j=0; j<2; j++) {
				System.out.print(r[i][j]+" ");
				if(r[i][j]>one) {
					two=one;
					one=r[i][j];
				}
				else if(r[i][j]>two) {
					two=r[i][j];
				}
			}
			System.out.println();
		}
		System.out.println(two);
	}
	private static long[] dfs(int v) {
		System.out.println("V"+v);
		long res[]=new long[3], order[][] = new long[3][2];
		int cnt=0;

		for(int i=0; i<g[v].size(); i++) {
			Node t= g[v].get(i);
			if(visited[t.d]) continue;
			
			visited[t.d]=true;
			cnt++;
			res = dfs(t.d); // go
			
			System.out.println("res:"+Arrays.toString(res));
			for(int j=0; j<3; j++) {
				if(res[j]<0) continue;
				if(res[j]+t.c>order[0][0]) {
					
				}else if(res[j]+t.c>order[1][0]) {
					
				}else if(res[j]+t.c>order[2][0]) {
					
				}
			}
		}
		
		return new long[] {one, two, three};
	}

}
