package BOJ.sds_algo.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717_집합의표현 {
	static int[] p;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		
		makeSet();
		int sel, a, b;
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			sel=Integer.parseInt(token.nextToken());
			a=Integer.parseInt(token.nextToken());
			b=Integer.parseInt(token.nextToken());
			if(sel==1) {
				if(findSet(a) == findSet(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}else {
				if(a<b) unionSet(a, b);
				else unionSet(b, a);
			}
		}
		
	}
	private static void unionSet(int a, int b) {
		a=findSet(a);
		b=findSet(b);
		p[b]=a;
	}
	private static int findSet(int a) {
		if(p[a]==a) return a;
		return p[a]=findSet(p[a]);
	}
	private static void makeSet() {
		p=new int[N+1];
		for(int i=0; i<=N; i++) 
			p[i]=i;
	}

}
