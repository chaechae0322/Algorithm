import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1922_Network {
	static int n,m;
	static class Edge implements Comparable<Edge>{
		int src, dst, cost;

		public Edge(int src, int dst, int cost) {
			this.src = src;
			this.dst = dst;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return (this.cost>o.cost)? 1: (this.cost==o.cost)? 0: -1;
		}
		
	}
	static ArrayList<Edge> E;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(br.readLine());
		E=new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			token=new StringTokenizer(br.readLine());
			E.add(new Edge(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()),
					Integer.parseInt(token.nextToken())));
		}//
		
		kruskal();

	}
	static int[] r;
	private static void kruskal() {
		Collections.sort(E);
		makeSet();
		
		int cnt=0, cost=0;
		for(int i=0; i<E.size(); i++) {
			if(cnt==n-1) break;
			
			Edge tmp=E.get(i);
			
			if(findSet(r[tmp.src]) != findSet(r[tmp.dst])) {
				unionSet(tmp.src, tmp.dst);
				cost+=tmp.cost;
				cnt++;
			}
		}
		System.out.println(cost);
		
	}
	private static void unionSet(int x, int y) {
		x=findSet(x);
		y=findSet(y);
		if(x==y) return;
		r[y]=x;
	}
	private static int findSet(int x) {
		if(x==r[x]) return x;
		int idx=findSet(r[x]);
		r[x]=idx;
		return r[x];
	}
	private static void makeSet() {
		r=new int[n+1];
		for(int i=0; i<=n; i++) 
			r[i]=i;		
	}

}
