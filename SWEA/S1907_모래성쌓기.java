package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1907_모래성쌓기 {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Pos> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc= Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			map=new int[N][M];
			visited=new boolean[N][M];
			q= new LinkedList<>();

			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine());
				String tmp = token.nextToken();
				for(int j=0; j<M; j++) {
					if(tmp.charAt(j)>='1'&& tmp.charAt(j)<='9') {
						map[i][j]=tmp.charAt(j)-'0';
					}
					else {
						q.add(new Pos(j, i));
						visited[i][j]=true;
					}
				}
			} //input

			ans=0;
			ans = solve();
			System.out.println("#"+t+" "+ans);
		}

	}
	static int ans;
	static int[] dx= {0,1,1,1,0,-1,-1,-1};
	static int[] dy= {-1,-1,0,1,1,1,0,-1};
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
	}
	private static int solve() {
		
		ArrayList<Pos> tosand= new ArrayList<>();
		int time=0;
		int tx=0, ty=0;
		int qsize=0;

		while(!q.isEmpty()) {
			qsize = q.size();
			
			System.out.println("time:"+time);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			
			for(int k=0; k<qsize; k++) {
				Pos tmp = q.poll();
				//System.out.println(tmp.toString());
				
				for(int i=0; i<8; i++) {
					tx=tmp.x+dx[i];
					ty=tmp.y+dy[i];
					
					if(tx<0||ty<0||tx>=M||ty>=N||visited[ty][tx]) continue;
		
					if(map[ty][tx]==0) {  // 모래 
						visited[ty][tx]=true;
						q.add(new Pos(tx, ty));
					}
					else {  // 숫자면
						map[ty][tx]-=1; // 1씩 깎는다.
						if(map[ty][tx]==0) {
							tosand.add(new Pos(tx, ty));
							visited[ty][tx]=true;
							q.add(new Pos(tx, ty));
						}
					}
				}
				
			}
			time++;
			
			for(int i=0; i<tosand.size(); i++) {
				map[tosand.get(i).y][tosand.get(i).x]=0;
			}
			tosand.clear();
		}
		return time-1;
	}

}
