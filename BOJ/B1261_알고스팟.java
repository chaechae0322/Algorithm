package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1261_알고스팟 {
	static class Node {
		int x, y, cnt;

		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}
	
	static char[][] map;
	static int[][] crush;
	static boolean[][] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map = new char[N][M];
		crush = new int[N][M];
		
		visited = new boolean[N][M];
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			map[i] = token.nextToken().toCharArray();
			Arrays.fill(crush[i], Integer.MAX_VALUE);
		}
		
		System.out.println("dd");
		solve();
		if(ans==Integer.MAX_VALUE) System.out.println("0");
		else System.out.println(ans);
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int ans = Integer.MAX_VALUE;
	private static void solve() {
		Queue<Node> q= new LinkedList<>();
		int tx=0, ty=0;
		q.add(new Node(0, 0, 0));
		visited[0][0]=true;
		crush[0][0]=0;
		
		int ncnt =0 ;
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			System.out.println(tmp.toString());
			
			for(int i=0; i<4; i++) {
				tx = tmp.x+dx[i];
				ty = tmp.y+dy[i];
				if(tx<0||ty<0||tx>=M||ty>=N) continue;
				
				
				ncnt = tmp.cnt;
				if(map[ty][tx]=='1') ncnt++;
				if(crush[ty][tx]<=ncnt) continue;
				

				System.out.println("tx:"+tx+" ty:"+ty+" tcnt:"+ncnt);
				crush[ty][tx]=ncnt;
				
				q.add(new Node(tx, ty, ncnt));
				
				
				if(tx==M-1 && ty==N-1) {
					ans= Math.min(ans, ncnt);
				}
			}
		}
	}

}
