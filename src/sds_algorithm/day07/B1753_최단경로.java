package sds_algorithm.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753_최단경로 {
	static int V, E, S;
	static int[] dist;
	static ArrayList<Node>[] glist;
	static class Node{
		int dst, cost;

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
			return "Node [dst=" + dst + ", cost=" + cost + "]";
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		V=Integer.parseInt(token.nextToken());
		E=Integer.parseInt(token.nextToken());
		S=Integer.parseInt(br.readLine());
		
		glist=new ArrayList[V+1];
		dist=new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0; i<=V; i++) glist[i]=new ArrayList<>();
		for(int i=0; i<E; i++) {
			token = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(token.nextToken());
			int b=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			glist[a].add(new Node(b, c));
		}
		dijkstra();
	}
	private static void dijkstra() {
		PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
		pq.add(new Node(S, 0));
		dist[S]=0;
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			System.out.println(tmp.toString());
			if(tmp.dst != S && dist[tmp.dst]!=Integer.MAX_VALUE) continue;
			
			dist[tmp.dst]=tmp.cost;
			for(int i=0; i<glist[tmp.dst].size(); i++){
				Node t=glist[tmp.dst].get(i);
				if(t.cost+tmp.cost<dist[t.dst]) {
					pq.add(new Node(t.dst, tmp.cost+t.cost));
				}
			}
		}
		//System.out.println(Arrays.toString(dist));
		for(int i=1; i<=V; i++) {
			if(dist[i]==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

}
