package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author chaeeun
 * 
 * 프로그래머스 지형이동 
 * BFS, Kruskal
 *
 */

public class 지형이동_kruskal{
	
	public static void main(String[] args) {
		int[][] land = {
				//{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}
				//{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
				{2, 1,2,1}, {1, 5, 6, 2}, {8, 4, 7, 20}, {10,10,22,21}
		};
		int height = 3;
		
		System.out.println(solution(land, height));
	}
	
	static class Node implements Comparable<Node>{
		int src, dst, cost;

		public Node(int src, int dst, int cost) {
			super();
			this.src = src;
			this.dst = dst;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [src=" + src + ", dst=" + dst + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
		
	}

	static int[][] map;
	static boolean[][] visited;
	static int[] p;
	private static int solution(int[][] land, int height) {
		int n=land.length;
		map = new int[n][n];
		visited = new boolean[n][n];
		EdgeList=new ArrayList<>();
		
		int id=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(j,i,++id,land,height);
				}
			}
		}
		
		
		int tx=0, ty=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<4; k++) {
					tx=j+dx[k];
					ty=i+dy[k];
					
					if(tx<0||ty<0||tx>=n||ty>=n) continue;
					if(map[ty][tx]!=map[i][j]) {
						EdgeList.add(new Node(map[i][j], map[ty][tx], Math.abs(land[i][j]-land[ty][tx])));
					}
				}
			}
		}
		
		
		//kruskal
		p=new int[id+1];
		initSet(id);
		Collections.sort(EdgeList);
		int cnt=0;
		int answer=0;
		for(int i=0; i<EdgeList.size(); i++) {
			Node tmp = EdgeList.get(i);
			System.out.println(tmp.toString());
			
			if(findSet(tmp.src) != findSet(tmp.dst)) {
				unionSet(tmp.src, tmp.dst);
				cnt++;
				answer += tmp.cost;
				
				if(cnt==id-1) break;
			}
		}
		
		
		return answer;
	}
	private static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x==y) return;
		p[y]=x;
	}
	private static int findSet(int x) {
		if(x==p[x]) return x;
		int idx=findSet(p[x]);
		p[x]=idx;
		return p[x];
	}
	private static void initSet(int n) {
		for(int i=0; i<=n; i++)
			p[i]=i;
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static ArrayList<Node> EdgeList;
	private static void bfs(int x, int y, int id, int[][] land, int height) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[y][x]=true;
		map[y][x]=id;
		
		int tx=0, ty=0, n=land.length;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				
				if(tx<0||ty<0||tx>=n||ty>=n||visited[ty][tx]) continue;
				if(Math.abs(land[tmp[1]][tmp[0]]-land[ty][tx])>height) { // different id
					//EdgeList.add(new Node(map[tmp[1]][tmp[0]], map[ty][tx], Math.abs(land[tmp[1]][tmp[0]]-land[ty][tx])));
					continue;
				}
				
				q.add(new int[] {tx, ty});
				map[ty][tx]=id;
				visited[ty][tx]=true;
			}
		}
	}
}