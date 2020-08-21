package BOJ.sds_algo.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *  Union Find Set
 *  존나어렵다.
 */
public class B3830_교수는안기다려 {
	static int[] p;
	static long[] diff;
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;

		while(true) {
			token = new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			if(N==0 && M==0) break;

			// makeSet
			p = new int[N+1];
			diff = new long[N+1];
			for(int i=0; i<=N; i++) p[i]=i;

			for(int i=0; i<M; i++) {
				token = new StringTokenizer(br.readLine());
				char ch = token.nextToken().charAt(0);
				int a= Integer.parseInt(token.nextToken());
				int b= Integer.parseInt(token.nextToken());

				if(ch=='!') {
					union(a, b, Integer.parseInt(token.nextToken()));
				}else {
					int pa=find(a);  // find 할때 p, diff 갱신
					int pb=find(b);
					if(pa!=pb) {
						System.out.println("UNKNOWN");
					}else {
						
						System.out.println(diff[b]-diff[a]);
					}
				}
			}
		}
	}
	private static void union(int a, int b, int val) {
		if(a>b) {  
			int t=a; a=b; b=t; // 항상 작은 노드가 부모가 되도록 
			val*=(-1); // 무게도 반대
		}
		int pa=find(a);
		int pb=find(b);
		if(pa!=pb) { // 서로 다른 집합이면
			diff[pb]=diff[a]+val-diff[b];  // 항상 앞에 a가 기준이 되니까 수식에의해 이렇게 해야한다...
		}
		p[pb]=pa;

	}
	private static int find(int a) {
		if(p[a]==a) return a;
		
		int pa=find(p[a]);
		diff[a]+=diff[p[a]];  // 부모꺼 더한다
		p[a]=pa;
		return p[a];
	}


}
