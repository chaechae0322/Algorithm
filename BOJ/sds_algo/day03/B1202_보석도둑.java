package BOJ.sds_algo.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202_보석도둑 {
	static int N, K;
	static class Node implements Comparable<Node>{
		int w, v;
		public Node (int w, int v) {
			this.w=w;
			this.v=v;
		}
		public int getW() {
			return w;
		}
		public void setW(int w) {
			this.w = w;
		}
		public int getV() {
			return v;
		}
		public void setV(int v) {
			this.v = v;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
		@Override
		public String toString() {
			return "Node [w=" + w + ", v=" + v + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		K=Integer.parseInt(token.nextToken());
		
		Node[] bosuck=new Node[N];
		int[] bag= new int[K];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			bosuck[i]=new Node(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
		}
		for(int i=0; i<K; i++) {
			token = new StringTokenizer(br.readLine());
			bag[i]=Integer.parseInt(token.nextToken());
		}
		Arrays.sort(bag);
		Arrays.sort(bosuck, Comparator.comparingInt(Node::getW));
		System.out.println(Arrays.toString(bag));
		System.out.println(Arrays.toString(bosuck));
		
/*		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.v-o1.v;
			}
			
		});*/
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getV).reversed());
		
		int idx=0;
		long ans=0;
		
		for(int i=0; i<K; i++) {
			
			while(idx<N) {
				if(bosuck[idx].w <= bag[i]) {
					pq.add(bosuck[idx++]);
			
					System.out.println(pq);
				}else {
					break;
				}
			}
			if(pq.size()>0) ans+=(long)(pq.poll().v);
		}
		System.out.println(ans);
	}

}
