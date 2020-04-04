import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	static int m;
	static int n;
	static int[][] map;
	static Queue<pos> q;
	static class pos{
		int x,y,day;
		public pos(int x, int y, int day) {
			this.x=x;
			this.y=y;
			this.day=day;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		m=Integer.parseInt(token.nextToken());
		n=Integer.parseInt(token.nextToken());
		q=new LinkedList<>();
		map=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {		
				map[i][j]=Integer.parseInt(token.nextToken());
				if(map[i][j]==1) {
					cnt+=1;
					q.add(new pos(j,i,0));
					visited[i][j]=true;
				}
				else if(map[i][j]==-1) { // 없는 곳도 체크 (방문 안하도록)
					cnt+=1;
					visited[i][j]=true;
				}
			}
		}//
		
		ans=Integer.MAX_VALUE;
		bfs();
		
		if(ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else System.out.println(ans);
		

	}
	static int ans;
	static int cnt;
	static boolean[][] visited;
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	
	private static void bfs() {	
		pos tmp=new pos(0,0,0);
		int cur=0, pre=0;
		int tx=0, ty=0;
		
//		if(check()) {
//			ans=cur;
//			return;
//		}
		if(cnt == n*m) {
			ans=cur;
			return;
		}
		
		while(!q.isEmpty()) {
			tmp=q.poll();
			cur=tmp.day;
//			if(pre != cur) { // 하루가 지났다.
//				if(check()) { // 다 익었는지 확인
//					ans=cur;
//					return;
//				}
//				
//			}
			
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				
				if(tx<0 || ty<0 || tx>=m || ty>=n || visited[ty][tx]) continue;
				
				if(map[ty][tx]==0) {
					cnt+=1;
					if(cnt == n*m) {
						ans = cur+1;
						return;
					}
					visited[ty][tx]=true;
					q.add(new pos(tx, ty, tmp.day+1));
				}
			}
			
			
			pre=cur;
		}
		
		
		if(cnt == n*m) {
			ans=cur;
			return;
		}
		
	}
	private static boolean check() {
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j])
					cnt+=1;
			}
		}
		if(cnt==n*m) return true;
		else return false;
	}

}
