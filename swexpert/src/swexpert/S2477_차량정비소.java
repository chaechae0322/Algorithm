package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2477_차량정비소 {
	static class Node implements Comparable<Node>{
		int id, time, sel;

		public Node(int id, int time, int sel) {
			super();
			this.id = id;
			this.time = time;
			this.sel = sel;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", time=" + time + ", sel=" + sel + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}
	static int N, M, K, A,B;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			K=Integer.parseInt(token.nextToken());
			A=Integer.parseInt(token.nextToken())-1;
			B=Integer.parseInt(token.nextToken())-1;
		}
		
		PriorityQueue<Node> man=new PriorityQueue<>();
		PriorityQueue<Node>[] n = new PriorityQueue[N];
		PriorityQueue<Node>[] m = new PriorityQueue[M];
		int[] ninfo=new int[N];
		int[] minfo=new int[M];
		token = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			n[i]=new PriorityQueue<>();
			ninfo[i]=Integer.parseInt(token.nextToken());
		}
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			m[i]=new PriorityQueue<>();
			minfo[i]=Integer.parseInt(token.nextToken());
		}
		token=new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			man.add(new Node(i+1, Integer.parseInt(token.nextToken()), 0));
		}
		
		
		int t=0; 
		for(;;) {
			//m poll
			for(int i=0; i<M; i++) {
				
			}
			
			//n poll
			
			//man poll
			
			
			
			t++;
		}

	}

}
