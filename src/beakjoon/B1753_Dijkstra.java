import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class B1753_Dijkstra {
	static int v,e;
	//static int[][] map;
	static class Node implements Comparable<Node>{
		int vert, cost;


		public Node(int vert, int cost) {
			this.vert = vert;
			this.cost = cost;
		}


		@Override
		public String toString() {
			return "Node [vert=" + vert + ", cost=" + cost + "]";
		}


		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		v=Integer.parseInt(token.nextToken());
		e=Integer.parseInt(token.nextToken());
		list=new ArrayList[v+1];
		for(int i=0; i<list.length; i++)
			list[i]=new ArrayList<>();
		
		int start=Integer.parseInt(br.readLine());
		int src=0, dst=0;
		for(int i=0; i<e; i++) {
			token = new StringTokenizer(br.readLine());
			
			src=Integer.parseInt(token.nextToken());
			dst=Integer.parseInt(token.nextToken());
			
			list[src].add(new Node(dst, Integer.parseInt(token.nextToken())));
		}
		
		dijkstra(start);
	}
	public static void dijkstra(int start) {
		Queue<Node> pq=new PriorityQueue<>();
		int[] dist=new int[v+1];
		pq.add(new Node(start, 0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		Node tmp=null, t=null;
		while(!pq.isEmpty()) {
			// 가장 가까운 곳
			tmp=pq.poll();
			//System.out.println(tmp);
			
			//.out.println("탐색");
			for(int i=0; i<list[tmp.vert].size(); i++) {
				t=list[tmp.vert].get(i);
				//System.out.println(t);
				
				if(dist[t.vert] > t.cost+tmp.cost) {
					//System.out.println("add");
					dist[t.vert]=t.cost+tmp.cost;
					pq.add(new Node(t.vert, dist[t.vert]));
				}
			}
		}
		
		for(int i=1; i<=v; i++) {
			if(dist[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else System.out.println(dist[i]);
		}
	
	}

}
