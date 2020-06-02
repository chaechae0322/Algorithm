package beakjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B2982_국왕의방문 {
	static class Node implements Comparable<Node>{
		int dst, cost;

		
		public Node(int dst, int cost) {
			super();
			this.dst = dst;
			this.cost = cost;
		}


		@Override
		public String toString() {
			return "Node [dst=" + dst + ", cost=" + cost + "]";
		}


		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	static int[][] graph;
	static int[][] king;
	static int N, M, A, B, K, G;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		A=sc.nextInt(); B=sc.nextInt();
		K=sc.nextInt(); G=sc.nextInt();
		
		int[] kingpath = new int[G];
		for(int i=0; i<G; i++) {
			kingpath[i]=sc.nextInt();
		}
		
		graph=new int[N+1][N+1];
		king=new int[N+1][N+1];
		for(int i=0; i<=N; i++)
			Arrays.fill(king[i], -1);
		dist=new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		int x=0, y=0, cost=0;
		for(int i=0; i<M; i++) {
			x=sc.nextInt();
			y=sc.nextInt();
			cost=sc.nextInt();
			graph[x][y]=cost;
			graph[y][x]=cost;
		}
		
		int sec = 0;
		for(int i=0; i<kingpath.length-1; i++) {
			king[kingpath[i]][kingpath[i+1]] = sec;
			king[kingpath[i+1]][kingpath[i]] = sec;  // 진입시기
			sec += graph[kingpath[i+1]][kingpath[i]];
		}
		
		solve();
		System.out.println(dist[B]-K);
	}

	static int[] dist;
	private static void solve() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		dist[A]=K;
		q.add(new Node(A, K));
		
		int ncost = 0;
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			ncost = tmp.cost;
			
			
			for(int i=0; i<=N; i++) {
				
				if(graph[tmp.dst][i]!=0) {  // 연결된 도로가 있을 때
				
					ncost = tmp.cost+graph[tmp.dst][i];
					
					if(king[tmp.dst][i]!=-1 && tmp.cost>=king[tmp.dst][i] && tmp.cost < king[tmp.dst][i]+graph[tmp.dst][i]) { // 왕이 건너는 곳
						ncost = (king[tmp.dst][i]+2*graph[tmp.dst][i]);
					}
					
					if(dist[i] > ncost) {
						dist[i]=ncost;
						q.add(new Node(i, ncost));
					}
				}
				
			}
		}
		
	}

}
