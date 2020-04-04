import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class RectEscape {
	static int m, n;
	static int[][] map;
	
	static class rect{
		int sx, sy, w,h;
		int num;
		
		public rect() {}
		public rect(int sx, int sy, int w, int h, int num) {
			this.sx = sx;
			this.sy = sy;
			this.w = w;
			this.h = h;
			this.num = num;
		}
		@Override
		public String toString() {
			return "rect [sx=" + sx + ", sy=" + sy + ", w=" + w + ", h=" + h + ", num=" + num + "]";
		};
		
		
	}
	static rect tar;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token= new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		map=new int[n][m];
		
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		
		tar=new rect();
		rect cur=new rect();
		token=new StringTokenizer(br.readLine());
		cur.h=Integer.parseInt(token.nextToken());
		cur.w=Integer.parseInt(token.nextToken());
		cur.sy=Integer.parseInt(token.nextToken())-1;
		cur.sx=Integer.parseInt(token.nextToken())-1;
		tar.sy=Integer.parseInt(token.nextToken())-1;
		tar.sx=Integer.parseInt(token.nextToken())-1;
		
//		System.out.println(tar.toString());
//		
//		System.out.println(cur.toString());
		ans=Integer.MAX_VALUE;
		bfs(cur);
		
		if(ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else 
			System.out.println(ans);

	}
	static int ans;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void bfs(rect cur) {
		Queue<rect> q=new LinkedList<>();
		q.add(cur);
		
		if(check2(cur)) {
			ans=0;
			return;
		}
		
		boolean[][] visited=new boolean[n][m];
		visited[cur.sy][cur.sx]=true;
//		System.out.println(visited[cur.sy][cur.sx]);
		
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			rect tmp=q.poll();
//			System.out.println("start :"+tmp.toString());
			
			
			
//			if(tmp.num == 1) {
//				System.out.println("dfdf");
//			}
			
			for(int i=0; i<4; i++) {
				
				if(check(i, tmp, visited)) { // 이동 할 수 있는지
					rect ntmp=move(i, tmp); // 이동
					
					if(check2(ntmp)) { // 목표랑 일치하는지
						ans=tmp.num+1;
						return;
					}
//					System.out.println(ntmp.toString()+" dir:"+i+" depth:"+tmp.num);
					
					
					visited[ntmp.sy][ntmp.sx]=true;
					ntmp.num=tmp.num+1;
					q.add(ntmp);
				}
				
			}
		}
		
	}
	
	private static boolean check2(rect ntmp) {
		return (ntmp.sx == tar.sx && ntmp.sy == tar.sy);
	}
	
	private static rect move(int dir, rect tmp) {
		rect res=new rect();
		res.sx=tmp.sx+dx[dir];
		res.sy=tmp.sy+dy[dir];
		res.h=tmp.h;
		res.w=tmp.w;
		res.num=tmp.num;
		
		return res;
	}
	
	private static boolean check(int dir, rect tmp, boolean[][] visited) {
		int x=tmp.sx;
		int y=tmp.sy;
		int w=tmp.w;
		int h=tmp.h;
		
		
		
		
		int tx=x, ty=y;
		for(int i=y; i<y+h; i++) {
			ty=i+dy[dir];
			for(int j=x; j<x+w; j++) {
				tx=j+dx[dir];
				
				
		
//					System.out.println("x:"+x+" y:"+y);
//					System.out.println("tx:"+tx+" ty:"+ty);

				
				
				if(tx<0 || ty<0 || tx>=m || ty>=n) return false;
				if(i==y && j==x && visited[ty][tx]) return false;
				
				if(map[ty][tx]==1) return false;
				
			}
		}
		
		
		return true;
	}

}
