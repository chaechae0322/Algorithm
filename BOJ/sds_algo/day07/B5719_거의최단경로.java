package BOJ.sds_algo.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 *  Dijkstra 
 *  BFS
 */
public class B5719_거의최단경로 {
	static int[] dist;
	static boolean[] visited;
	static int N,M,S,D;
	static ArrayList<Node>[] glist;
	static class Node{
		int dst, cost;
		boolean path;

		public Node(int dst, int cost) {
			super();
			this.dst = dst;
			this.cost = cost;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [dst=" + dst + ", cost=" + cost + ", path=" + path + "]";
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		while(true) {
			token = new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			if(N==0 && M==0) break;
			token = new StringTokenizer(br.readLine());
			S=Integer.parseInt(token.nextToken());
			D=Integer.parseInt(token.nextToken());
			
			glist=new ArrayList[N];
			exlist=new ArrayList[N];
			dist=new int[N];
			
			for(int i=0; i<N; i++) {
				glist[i]=new ArrayList<>();
				exlist[i]=new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				token = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(token.nextToken());
				int b=Integer.parseInt(token.nextToken());
				int c=Integer.parseInt(token.nextToken());
				glist[a].add(new Node(b, c));
				exlist[b].add(new Node(a,c));
			}
			//System.out.println();
			dijkstra();
			bfs();
			dijkstra();
			if(dist[D]==Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(dist[D]);
			}
		}
	}
	static ArrayList<Node>[] exlist;
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited= new boolean[N];
		visited[D]=true;
		q.add(new int[] {D, 0});
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<exlist[tmp[0]].size(); i++) {
				Node t=exlist[tmp[0]].get(i);
				
				if(dist[tmp[0]]-t.cost == dist[t.dst] && !visited[t.dst]) { // 최단경로에 있는 도로라면
					//t.path=true;
					// 정방향 플래그 체크 
					for(int k=0; k<glist[t.dst].size(); k++) {
						if(glist[t.dst].get(k).dst==tmp[0]) {
							glist[t.dst].get(k).path=true;
							break;
						}
					}
					q.add(new int[] {t.dst, tmp[1]+t.cost});
				}
			}
		}
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
		pq.add(new Node(S, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S]=0;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			if(tmp.dst!=S && dist[tmp.dst]!=Integer.MAX_VALUE) continue;
			
			dist[tmp.dst]=tmp.cost;
			if(tmp.dst==D) {
				break;
			}
			
			for(int i=0; i<glist[tmp.dst].size(); i++) {
				Node t=glist[tmp.dst].get(i); // 도로
				if(dist[t.dst]>tmp.cost+t.cost && !t.path) {
					pq.add(new Node(t.dst, tmp.cost+t.cost));
				}
			}
		}
	}

}
