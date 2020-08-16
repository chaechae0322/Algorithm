package sds_algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1103_게임 {
	static int N,M;
	static int[][] map;
	static int[][] graph;
	static boolean[][] visited;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new int[N][M];
		graph=new int[N*M][N*M];
		visited=new boolean[N][M];
		dp=new int[N][M];
		
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			String tmp = token.nextToken();
			for(int j=0; j<M; j++) {
				if(tmp.charAt(j)=='H') {
					map[i][j]=-1;
				}else {
					map[i][j]=tmp.charAt(j)-'0';
				}
			}
		}
		
		if(M==1 && N==1) {
			System.out.println(0);
			return;
		}
		
		circular=false;
		
		visited[0][0]=true;
		dfs(0, 0, 0);
		if(circular) System.out.println(-1);
		else System.out.println(dp[0][0]);
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	static boolean circular;
	private static int dfs(int x, int y, int cnt) {
		System.out.println("dfs x:"+x+" y:"+y+" cnt:"+cnt);
		if(circular) return 0;
		if(dp[y][x]!=0) {
			return dp[y][x];
		}
		
		int tx=0, ty=0;
		int go=0;
		loop: for(int i=0; i<4; i++) {
			tx=x+dx[i];
			ty=y+dy[i];
			if(tx<0||ty<0||tx>=M||ty>=N) continue;
			
			
			for(int j=0; j<map[y][x]-1; j++) {
				tx+=dx[i];
				ty+=dy[i];
				if(tx<0||ty<0||tx>=M||ty>=N) continue loop;
			}
			
			if(map[ty][tx]==-1) continue;
			
			if(visited[ty][tx]) {
				circular=true;
				return 0;
			}
			
			//System.out.println("go tx:"+tx+" ty:"+ty);
			go=1;
			visited[ty][tx]=true;
			dp[y][x]=Math.max(dp[y][x], dfs(tx, ty, cnt+1)+1);
			visited[ty][tx]=false;
		}
		
		
		if(go==0) {
			dp[y][x]=1;
		}
		System.out.println("dp["+y+"]["+x+"]="+dp[y][x]);
		return dp[y][x];
	}

}
