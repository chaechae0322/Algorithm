package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B19238_스타트택시 {
	static class Point implements Comparable<Point>{
		int x, y, c;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public Point(int x, int y, int c) {
			this.x=x;
			this.y=y;
			this.c=c;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", c=" + c +"]";
		}
		@Override
		public int compareTo(Point o) {
			if(o.c==this.c) {
				if(o.y==this.y) {
					return this.x-o.x;
				}else {
					return this.y-o.y;
				}
			}else {
				return this.c-o.c;
			}
		}
	}

	static int N, M, F;
	static int[][] map;
	static Point[] dsts;
	static boolean[] check;
	static int sx, sy;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		F=Integer.parseInt(token.nextToken());
		
		map = new int[N][N];
		dsts=new Point[M+1];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
				if(map[i][j]==1) {
					map[i][j]=-1;
				}
			}
		}
		
		
		token = new StringTokenizer(br.readLine());
		sy=Integer.parseInt(token.nextToken())-1;
		sx=Integer.parseInt(token.nextToken())-1;
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			int y=Integer.parseInt(token.nextToken());
			int x=Integer.parseInt(token.nextToken());
			int dy=Integer.parseInt(token.nextToken());
			int dx=Integer.parseInt(token.nextToken());
			
			map[y-1][x-1]=i+1;
			dsts[i+1] = new Point(dx-1, dy-1);
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		check = new boolean[M+1];
		
		
		for(int i=0; i<M; i++) {
			if(drive()==-1) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(F);
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static int drive() {
		
		
		Queue<Point> q= new LinkedList<>();
		boolean[][] visited= new boolean[N][N];
		ArrayList<Point> findarr=new ArrayList<>();
		visited[sy][sx]=true;
		q.add(new Point(sx, sy, 0));
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			
			// 내자리에서 손님
			if(map[sy][sx]>0) {
				System.out.println("dd:?");
				findarr.add(new Point(sx, sy, 0));
				break;
			}
			
			int qsize = q.size();
			for(int i=0; i<qsize; i++) {
				Point tmp = q.poll();
				System.out.println(tmp.toString());
				
				for(int j=0; j<4; j++) {
					tx=tmp.x+dx[j];
					ty=tmp.y+dy[j];
					//
					if(tx<0||tx>=N||ty<0||ty>=N||visited[ty][tx]||map[ty][tx]==-1) continue;
					//System.out.println(tx+" "+ty);
					//System.out.println(map[ty][tx]);
					if(map[ty][tx]!=0) {
						findarr.add(new Point(tx, ty, tmp.c+1));
					}
					visited[ty][tx]=true;
					q.add(new Point(tx, ty, tmp.c+1));
				}
			}
			
			if(findarr.size()!=0) {
				Collections.sort(findarr);
				/*for(Point p : findarr) {
					System.out.println(p.toString());
				}*/
				break;
			}
		}
		if(findarr.size()==0) return -1;
		System.out.println(findarr.get(0));
		if(F-findarr.get(0).c <= 0) return -1;
		
		// destination
		int num = map[findarr.get(0).y][findarr.get(0).x];
		q.clear();
		visited=new boolean[N][N];
		sx=findarr.get(0).x; sy=findarr.get(0).y;
		visited[sy][sx]=true;
		q.add(new Point(sx, sy, 0));
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				if(tx<0||tx>=N||ty<0||ty>=N||visited[ty][tx]||map[ty][tx]==-1) continue;
				
				System.out.println("num:"+num);
				if(tx==dsts[num].x && ty==dsts[num].y) {
					System.out.println("dd"+ tx+" "+ty);
					if(F-findarr.get(0).c-(tmp.c+1)<0) return -1;
					F = F-findarr.get(0).c + tmp.c+1;
					sx=tx; sy=ty;
					check[num]=true;
					map[findarr.get(0).y][findarr.get(0).x] = 0;
					
					for(int ii=0; ii<N; ii++)
					{
						System.out.println();
						for(int jj=0; jj<N; jj++)System.out.print(map[ii][jj]+" ");
						
					}
					
					return 0;
				}
				q.add(new Point(tx, ty, tmp.c+1));
				visited[ty][tx]=true;
			}
		}
		
		return -1;
	}

}
