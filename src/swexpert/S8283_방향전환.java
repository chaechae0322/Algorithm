package swexpert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S8283_방향전환 {
	static class Pos {
		int x, y, predir, cost;
		
		public Pos(int x, int y, int predir, int cost) {
			this.x=x;
			this.y=y;
			this.predir=predir;
			this.cost=cost;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", predir="+predir+", cost="+cost+"]";
		}
	}
	static int srcx, srcy, dstx, dsty;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=1; t<=tc; t++) {
			map=new int[201][201];
			srcx=sc.nextInt()+100;
			srcy=sc.nextInt()+100;
			dstx=sc.nextInt()+100;
			dsty=sc.nextInt()+100;
			
			int ans = bfs();
			System.out.println("#"+t+" "+ans);
		}

	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static int bfs() {
		if(srcx==dstx && srcy==dsty) return 0;
		
		boolean[][][] visited=new boolean[2][201][201];
		Queue<Pos> q=new LinkedList<>();
		q.add(new Pos(srcx, srcy, -1, 0)); //0: 가로, 1:세로
		visited[0][srcy][srcx]=true;
		visited[1][srcy][srcx]=true;
		
		int tx=0, ty=0;
		int minx=0, maxx=0, miny=0, maxy=0;
		
		if(srcx>=dstx) {
			minx=dstx;
			maxx=srcx;
		}
		else {
			minx=srcx;
			maxx=dstx;
		}
		
		if(srcy>=dsty) {
			miny=dsty;
			maxy=srcy;
		}
		else {
			miny=srcy;
			maxy=dsty;
		}
		
		int dir=0;
		int ans=0;
		System.out.println(minx+" "+maxx+" "+miny+" "+maxy);
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			System.out.println(tmp.toString());
				
			for(int i=0; i<4; i++) {
				if(tmp.predir>-1 && (tmp.predir+i)%2==0) continue;
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				System.out.println(tx+" "+ty);
				
				if(tx<0||tx>=200||ty<0||ty>=200||visited[i%2][ty][tx]) {
					System.out.println("ddddd");
					continue;
				}
				
				if(ty==dsty && tx==dstx) {
					ans=tmp.cost+1;
					return ans;
				}
				visited[i%2][ty][tx]=true;
				q.add(new Pos(tx, ty, i%2, tmp.cost+1));
			}
		}
		
		return ans;
	}

}
