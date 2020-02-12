import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BlockPang {
	static int n;
	static int w;
	static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		
		for(int t=1; t<=tc; t++) {
			token=new StringTokenizer(br.readLine());
			n=Integer.parseInt(token.nextToken());
			w=Integer.parseInt(token.nextToken());
			h=Integer.parseInt(token.nextToken());
			

			int[][] map=new int[h][w];
			for(int i=0; i<h; i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j]=Integer.parseInt(token.nextToken());
				}
			}// 입력
			res=w*h;
			dfs(-1,0,map);
			
			System.out.println("#"+t+" "+res);
			
		}

	}
	static int res;
	static int cnt;
	private static void dfs(int pos, int depth, int[][] map) {
//		cnt+=1;
//		if(cnt>=10) return;
		if(res == 0) {
			return;
		}
		
		res = Math.min(res, count(map));
		
		if(depth == n) { // 4개 떨어뜨렸어..
			return;
		}
		
		int y=0;
		for(int i=0; i<w; i++) {
//			if(i==pos) continue;
			if((y=check(i, map))!=-1) { // 값이있는 열이면
				
//				System.out.println(i+"번째 열의 "+ "맨위에 있는 인덱스: "+y);
//				
//				if(pos==2 && depth == 1) {
//					System.out.println("before move  i:"+i);
//					printmap(map);
//				}
				
				int[][] nmap = move(i, y, map); // 구슬 떨어지는 곳
				
//				if(pos==2 && depth == 1) {
//					System.out.println("after move");
//					printmap(nmap);
//				}
				
				dfs(i, depth+1, nmap);
			}
		}
		
	}
	static void printmap(int[][] map) {
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static int check(int pos, int[][] map) {
		for(int i=0; i<h; i++)
			if(map[i][pos] != 0) {
				return i;
			}
		return -1;
	}

	private static int count(int[][] map) {
		int ans=0;
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(map[i][j]!=0)
					ans+=1;
			}
		}
		return ans;
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
		@Override
		public String toString() {
			return "pos [x=" + x + ", y=" + y + "]";
		}
		
	}
	private static int[][] move (int pos, int y, int[][] map) {
		int[][] nmap=new int[h][w];
		
		Queue<pos> q= new LinkedList<>();
		q.add(new pos(pos, y));
		boolean[][] visited=new boolean[h][w];
		visited[y][pos]=true;
		
		pos tmp=new pos(0,0);
		int dis=0, tx=0, ty=0;
		
		while(!q.isEmpty()) {
			tmp=q.poll();
			dis=map[tmp.y][tmp.x]-1;
			tx=tmp.x;
			ty=tmp.y;
//			System.out.println(tmp.toString()+" dis:"+dis);
			
			for(int i=0; i<4; i++) {
				tx=tmp.x;
				ty=tmp.y;
				for(int j=0; j<dis; j++) {
					tx+=dx[i];
					ty+=dy[i];
					
					
					
					if(tx<0 || ty<0 || tx>=w || ty>=h || visited[ty][tx]) continue;
					
//					System.out.println("tx:"+tx+" ty:"+ty+" value:"+map[ty][tx]);
					
					if(map[ty][tx]!=0) {
						visited[ty][tx]=true;
						q.add(new pos(tx,ty));
					}
				}
			}
		}
		
//		for(int i=0; i<h; i++) {
//			for(int j=0; j<w; j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		for(int j=0; j<w; j++) {
			q.clear();
			for(int i=h-1; i>=0; i--) {
				if(!visited[i][j] && map[i][j]!=0) {
					q.add(new pos(j,i));
				}
			}
			
			int c=0;
			while(!q.isEmpty()) {
				
				nmap[h-1-c][j]=map[q.peek().y][q.peek().x];
				c++;
				q.poll();
			}
		}
		
		
		return nmap;
		
		
	}
}
