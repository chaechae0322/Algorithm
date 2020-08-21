package BOJ.sds_algo.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1922_네트워크연결 {
	static class Node{
		int src, dst, cost;

		public Node(int src, int dst, int cost) {
			super();
			this.src = src;
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
			return "Node [src=" + src + ", dst=" + dst + ", cost=" + cost + "]";
		}
		
	}
	static Node[] glist;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		glist =new Node[2*N];
		int a=0, b=0, c=0;
		
        //int idx=0;
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			a=Integer.parseInt(token.nextToken());
			b=Integer.parseInt(token.nextToken());
			c=Integer.parseInt(token.nextToken());
			glist[2*i]=new Node(a, b, c);
            glist[2*i+1]=new Node(b, a, c);
		}
        
        if(N==1) {
			System.out.println(c);
			return;
		}
        
		Arrays.sort(glist, Comparator.comparingInt(Node::getCost));
		
		kruskal();
	}
	private static void kruskal() {
		int res=0;
		
		p=new int[N+1];
		for(int i=0; i<=N; i++)
			p[i]=i;
		
		int cnt=0;
		for(int i=0; i<glist.length; i++) {
			Node tmp = glist[i];
			System.out.println(tmp.toString());
			
			if(findSet(tmp.src) == findSet(tmp.dst)) continue;
			
			System.out.println("넣는다");
			if(tmp.src < tmp.dst) unionSet(tmp.src, tmp.dst);
			else unionSet(tmp.dst, tmp.src);
			res+=tmp.cost;
			cnt++;
			if(cnt==N-1) break;
		}
		System.out.println(res);
	}
	private static void unionSet(int a, int b) {
		a=findSet(a);
		b=findSet(b);
		p[b]=a;
	}
	static int[] p;
	private static int findSet(int a) {
		if(p[a]==a) return a;
		return p[a]=findSet(p[a]);
	}

}
