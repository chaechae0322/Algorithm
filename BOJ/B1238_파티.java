package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * Dijkstra 
 */
public class B1238_파티 {
	static int N,M,X,ind[], outd[];
	static ArrayList<Node>[] ing, outg;
	static class Node{
		int d,t;

		public Node(int d, int t) {
			super();
			this.d = d;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Node [d=" + d + ", t=" + t + "]";
		}

		public int getT() {
			return t;
		}

		public void setT(int t) {
			this.t = t;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		X=Integer.parseInt(token.nextToken());
		ing=new ArrayList[N+1]; outg=new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			ing[i]=new ArrayList<>();
			outg[i]=new ArrayList<>();
		}
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			outg[a].add(new Node(b,c)); 
			ing[b].add(new Node(a,c));
		}
		int ans = solve();
		System.out.println(ans);
	}
	private static int solve() {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getT));
		int[] dist=new int[N+1];
		pq.add(new Node(X,0));
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[X]=0;
		// go X 
		while(!pq.isEmpty()) {
			Node t=pq.poll();
			for(int i=0; i<ing[t.d].size(); i++) {
				int d=ing[t.d].get(i).d; int c=ing[t.d].get(i).t;
				if(dist[t.d]+c<dist[d]) {
					dist[d]=dist[t.d]+c;
					pq.add(new Node(d, c));
				}
			}
		}
		int[] res=dist.clone();
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Node(X,0));
		dist[X]=0;
		while(!pq.isEmpty()) {
			Node t=pq.poll();
			for(int i=0; i<outg[t.d].size(); i++) {
				int d=outg[t.d].get(i).d; int c=outg[t.d].get(i).t;
				if(dist[t.d]+c<dist[d]) {
					dist[d]=dist[t.d]+c;
					pq.add(new Node(d, c));
				}
			}
		}
		int max=0;
		for(int i=1; i<=N; i++) {
			if(i==X)continue;	
			res[i]+=dist[i];
			max=Math.max(res[i], max);
		}
		return max;
	}

}
