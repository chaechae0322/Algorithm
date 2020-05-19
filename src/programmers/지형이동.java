package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 지형이동 {
	
	public static void main(String[] args) {
		int[][] land = {
				{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}
				//{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}
				//{2, 1,2,1}, {1, 5, 6, 2}, {8, 4, 7, 20}, {10,10,22,21}
		};
		int height = 3;
		
		System.out.println(solution(land, height));

	}
	
	static int[][] regions;
	static boolean[][] visited;
	static int[][] gland;
	static int[][] costgraph;
	static int id;
	public static int solution(int[][] land, int height) {
		int answer = 0;
		int n = land.length;
		regions = new int[n][n];
		visited = new boolean[n][n];
		gland = land;
		
		id=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs(j,i,++id, height);
				}
			}
		}
		
		
		
		System.out.println("regions check");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(regions[i][j]+" ");
			}
			System.out.println();
		}
		
		//
		costgraph = new int[id+1][id+1];
		for(int i=0; i<=id; i++)
			Arrays.fill(costgraph[i], Integer.MAX_VALUE);
		
		answer = findMinCost();
		
		
		return answer;
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
			return this.cost - o.cost;
		}
		
	}
	
	private static int findMinCost() {
		int tx=0, ty=0;
		for(int i=0; i<gland.length; i++) {
			for(int j=0; j<gland.length; j++) {
				for(int k=0; k<4; k++) {
					tx=j+dx[k];
					ty=i+dy[k];
					
					if(tx<0||ty<0||tx>=gland.length||ty>=gland.length) continue;
					if(regions[i][j] != regions[ty][tx]) {
						System.out.println("from:("+i+" "+j+")");
						System.out.println("to:("+ty+" "+tx+")");
						
						int src = regions[i][j];
						int dst = regions[ty][tx];
						
						if(costgraph[src][dst] > Math.abs(gland[i][j]-gland[ty][tx])) {
							System.out.println("min cost update :"+ Math.abs(gland[i][j]-gland[ty][tx]));
							costgraph[src][dst] = Math.abs(gland[i][j]-gland[ty][tx]);
							costgraph[dst][src] = Math.abs(gland[i][j]-gland[ty][tx]);
						}
					}
				}
			}
		}
		
		System.out.println("costgraph check");
		for(int i=0; i<costgraph.length; i++) {
			for(int j=i; j<costgraph.length; j++) {
				System.out.print(costgraph[i][j]+" ");
			}
			System.out.println();
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0; i<costgraph.length; i++) {
			for(int j=i; j<costgraph.length; j++) {
				if(costgraph[i][j]!=Integer.MAX_VALUE) {
					pq.add(new Node(i, j, costgraph[i][j]));
				}
			}
		}
		
		int res=0;
		int cnt=0;
		boolean[] visited = new boolean[id+1];
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			System.out.println(tmp.toString());
			
			if(!visited[tmp.src] || !visited[tmp.dst]) {
				res+=tmp.cost;
				visited[tmp.src] = true;
				visited[tmp.dst] = true;
				cnt++;
				
				if(cnt == id-1) break;
			}
		}
		return res;
	}
	
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void bfs(int x, int y, int id, int height) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		visited[y][x]=true;
		regions[y][x]=id;
		
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				
				if(tx<0||ty<0||tx>=gland.length||ty>=gland.length||visited[ty][tx]) continue;
				if(Math.abs(gland[ty][tx]-gland[tmp[1]][tmp[0]])>height) {
					
					continue;
				}
				
				q.add(new int[] {tx,ty});
				visited[ty][tx]=true;
				regions[ty][tx]=id;
			}
		}
		
	}

}
