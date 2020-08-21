package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 엔카4 {
	static int N,M;
	static int[][] g;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		
		g=new int[(int) (Math.pow(2, N)+1)][(int) (Math.pow(2, N)+1)];
		
		int bins1=0, bins2=0;
		String s1="", s2="";
 		for(int i=0; i<M; i++) {
 			token = new StringTokenizer(br.readLine());
 			s1=token.nextToken();
 			s2=token.nextToken();
 			//char[] s1=token.nextToken().toCharArray();
 			//char[] s2=token.nextToken().toCharArray();
 			int cost = Integer.parseInt(token.nextToken());
 			
 			bins1=0; bins2=0;
 			for(int j=0; j<N; j++) {
 				if(s1.charAt(N-1-j)=='o') {
 					bins1 += Math.pow(2, j);
 				}
 				if(s2.charAt(N-1-j)=='o') {
 					bins2 += Math.pow(2, j);
 				}
 			}
 			
 			g[bins1][bins2]=cost;
		}
 		
 		/*System.out.println("graph check");
 		for(int i=0; i<g.length; i++) {
 			for(int j=0; j<g[i].length; j++)
 				System.out.print(g[i][j]+" ");
 			System.out.println();
 		}*/
 		
 		int Q= Integer.parseInt(br.readLine());
 		for(int i=0; i<Q; i++) {
 			token = new StringTokenizer(br.readLine());
 			s1=token.nextToken();
 			s2=token.nextToken();
 			
 			bins1=0; bins2=0;
 			for(int j=0; j<N; j++) {
 				if(s1.charAt(N-1-j)=='o') {
 					bins1 += Math.pow(2, j);
 				}
 				if(s2.charAt(N-1-j)=='o') {
 					bins2 += Math.pow(2, j);
 				}
 			}
 			
 			if(bins1==bins2) {
 				System.out.println(0);
 				continue;
 			}
 			
 			//boolean[] visited = new boolean[(int) (Math.pow(2, N)+1)];
 			//visited[src]= true;
 			ans = Integer.MAX_VALUE;
 			//System.out.println("bins1:"+bins1+" bins2:"+bins2);
 			
 			
 			
 			bfs(bins1, bins2);
 			if(ans==Integer.MAX_VALUE) System.out.println(-1);
 			else System.out.println(ans);
 		}

	}
	static class Node implements Comparable<Node>{
		int v, cost;
		

		public Node(int v, int cost) {
			super();
			this.v = v;
			this.cost = cost;
		}


		@Override
		public String toString() {
			return "Node [v=" + v + ", cost=" + cost + "]";
		}


		@Override
		public int compareTo(Node o) {
			return o.cost-this.cost;
		}
		
	}

	static int ans;
	private static void bfs(int src, int dst) {
		Queue<Node> q=new LinkedList<>();
		int len = (int) (Math.pow(2, N)+1);
		boolean[] visited=new boolean[len];
		q.add(new Node(src, 0));
		visited[src]=true;
		
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			for(int i=0; i<len; i++) {
				if(g[tmp.v][i]!=0 && !visited[i]) {
					
					if(i==dst) {
						ans=Math.min(ans, tmp.cost+g[tmp.v][i]);
					}
					
					q.add(new Node(i, tmp.cost+g[tmp.v][i]));
					visited[i]=true;
				}
			}
		}
		
		
		
	}

}
