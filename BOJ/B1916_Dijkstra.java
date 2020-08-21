package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1916_Dijkstra {
	static int n,m;
	static ArrayList<Node>[] list;
	static class Node implements Comparable<Node>{
		int vert;
		long cost;

		public Node(int vert, long dist) {
			this.vert = vert;
			this.cost = dist;
		}

		@Override
		public String toString() {
			return "Node [vert=" + vert + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost>o.cost?1:-1;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token =new StringTokenizer(br.readLine());

		n=Integer.parseInt(token.nextToken()); //도시의 개수
		m=Integer.parseInt(br.readLine()); //버스의 갯수
		
		list=new ArrayList[n+1];
		for(int i=0; i<list.length; i++)
			list[i]=new ArrayList<>();
		
		int src=0, dst=0;
		for(int i=0; i<m; i++) {
			token = new StringTokenizer(br.readLine());
			src=Integer.parseInt(token.nextToken());
			dst=Integer.parseInt(token.nextToken());
			
			list[src].add(new Node(dst, Integer.parseInt(token.nextToken())));
		}
		
		token = new StringTokenizer(br.readLine());
		int start=Integer.parseInt(token.nextToken()), 
				end=Integer.parseInt(token.nextToken());
		
		dijkstra(start, end);
	}
	private static void dijkstra(int start, int end) {
		Queue<Node> pq=new PriorityQueue<>();
		pq.add(new Node(start, 0));
		long[] dist=new long[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		Node tmp=null, t=null;
		while(!pq.isEmpty()) {
			tmp=pq.poll();
			//System.out.println("현재:"+tmp);
			
			//System.out.println("탐색");
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
		
		System.out.println(dist[end]);
	}

}
