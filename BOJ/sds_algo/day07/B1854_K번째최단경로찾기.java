package BOJ.sds_algo.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1854_K번째최단경로찾기 {
	static int N,M,K;
	static class Node{
		int dst;
		long cost;

		public long getCost() {
			return cost;
		}

		public void setCost(long cost) {
			this.cost = cost;
		}

		public Node(int dst, long cost) {
			super();
			this.dst = dst;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [dst=" + dst + ", cost=" + cost + "]";
		}
		
	}
	static ArrayList<Node>[] glist;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken()); M=Integer.parseInt(token.nextToken());
		K=Integer.parseInt(token.nextToken());
		
		glist=new ArrayList[N+1];
		for(int i=0; i<=N; i++) glist[i]=new ArrayList<>();
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			long c=Long.parseLong(token.nextToken());
			glist[a].add(new Node(b, (long)c)); //glist[b].add(new Node(a, c));
		}
		
		kdijkstre();
	}
	private static void kdijkstre() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(Node::getCost));
		long[] dist=new long[N+1]; // distance
		Arrays.fill(dist, Long.MAX_VALUE);
		int[] cnt=new int[N+1];
		Arrays.fill(cnt, K); // visited
		
		pq.add(new Node(1, 0)); // 일반적으론 0
		//dist[1]=0;
		//cnt[1]--;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			System.out.println(tmp.toString());
			if(/*dist[tmp.dst]==tmp.cost || */cnt[tmp.dst]==0) continue; // 같으면 
			
			cnt[tmp.dst]--;
			dist[tmp.dst]=tmp.cost;
			if(tmp.dst==5) {
				System.out.println(Arrays.toString(dist));
				System.out.println(Arrays.toString(cnt));
			}
			
			System.out.println("나 돌게");
			for(int i=0; i<glist[tmp.dst].size(); i++) {
				Node t=glist[tmp.dst].get(i);
				System.out.println(t.toString());
				if(cnt[t.dst]>0) { 
					pq.add(new Node(t.dst, dist[tmp.dst]+t.cost));
				}
			}
		}
		for(int i=1; i<=N; i++) {
			if(cnt[i]!=0) {
				System.out.println(-1);
			}else {
				System.out.println(dist[i]);
			}
		}
		
	}

}
