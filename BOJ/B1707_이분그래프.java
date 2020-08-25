package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS + Union-Find
 * 굉장히 까다롭다.
 */
public class B1707_이분그래프 {
	static int V,E,r[];
	static ArrayList<Integer> edge[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;// = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(br.readLine());
		loopt: for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			V=Integer.parseInt(token.nextToken()); E=Integer.parseInt(token.nextToken());
			edge=new ArrayList[V+1];
			r=new int[V+1];

			for(int i=0; i<=V; i++) {
				r[i]=i; //  makeSet
				edge[i]=new ArrayList<>();
			}
			for(int i=0; i<E; i++) {
				token = new StringTokenizer(br.readLine());
				int a=Integer.parseInt(token.nextToken());
				int b=Integer.parseInt(token.nextToken());
				edge[a].add(b); edge[b].add(a);
				union(a,b);  // 집합 표시 why? 연결그래프가 아닐수도있음
			}

			int ref=-1, now=-1;
			int ans=1;
			visited = new boolean[V+1];
			set=new int[V+1];
			for(int i=1; i<=V; i++) {
				now=find(i);
				if(!visited[i] && ref!=now) {
					ans = bfs(i)*1;
					if(ans==0) {
						System.out.println("NO");
						continue loopt;
					}
				}
				ref=now;
			}
			System.out.println("YES");
		}


	}
	static boolean[] visited;
	static int[] set;
	private static int bfs(int root) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {root, 0, 1});
		visited[root]=true; set[root]=1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();

			for(int i=0; i<edge[tmp[0]].size(); i++) {
				int t=edge[tmp[0]].get(i);
				if(visited[t] && set[t]==tmp[2]) return 0;
				
				if(!visited[t]) {
					visited[t]=true;
					set[t]=tmp[2]==1?2:1;
					q.add(new int[] {t, tmp[0], set[t]}); // me parent sel
				}
			}

		}
		return 1;
	}
	private static void union(int a, int b) {
		if(a>b) {
			int t=a;
			a=b; b=t;
		}
		a=find(a); b=find(b);
		r[b]=a;
	}
	private static int find(int a) {
		if(r[a]==a) return a;
		return r[a]=find(r[a]);
	}

}
