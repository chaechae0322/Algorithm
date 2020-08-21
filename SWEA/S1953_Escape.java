package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1953_Escape {
	static int[][] map;
	static int n,m,l;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine()); //N M R C L
			n=Integer.parseInt(token.nextToken());
			m=Integer.parseInt(token.nextToken());
			int r=Integer.parseInt(token.nextToken());
			int c=Integer.parseInt(token.nextToken());
			l=Integer.parseInt(token.nextToken());

			map=new int[n][m];
			for(int i=0; i<n; i++) {
				token=new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++)
					map[i][j]=Integer.parseInt(token.nextToken());
			}//
			System.out.println("#"+t+" "+bfs(c,r));


		}

	}
	static class Pos{
		int x, y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static int bfs(int x, int y) {
		boolean[][] visited=new boolean[n][m];
		Queue<Pos> q=new LinkedList<>();
		q.add(new Pos(x, y));
		visited[y][x]=true;
		int tx=0, ty=0;
		int qsize=0;
		int order=1;
		while(order<l) {
			qsize=q.size();
			//System.out.println("qsize:"+qsize);
			
			

			
			
			for(int t=0; t<qsize; t++) {
				Pos tmp=q.poll();
				//System.out.println(tmp);
				
				for(int i=0; i<4; i++) {
					if(map[tmp.y][tmp.x]==2) {
						if(i==0||i==2) continue;
					}
					else if(map[tmp.y][tmp.x]==3) {
						if(i==1||i==3)continue;
					}
					else if(map[tmp.y][tmp.x]==4) {
						if(i==1||i==2)continue;
					}
					else if(map[tmp.y][tmp.x]==5) {
						if(i>1)continue;
					}
					else if(map[tmp.y][tmp.x]==6) {
						if(i==0||i==3)continue;
					}
					else if(map[tmp.y][tmp.x]==7) {
						if(i==0||i==1)continue;
					}

					tx=tmp.x+dx[i];
					ty=tmp.y+dy[i];
					if(tx<0||ty<0||ty>=n||tx>=m||map[ty][tx]==0||visited[ty][tx])continue;
					if(i==0) { //오른쪽
						if(map[ty][tx]==2||map[ty][tx]==4||map[ty][tx]==5) continue;
					}
					else if(i==1) {
						if(map[ty][tx]==3||map[ty][tx]==5||map[ty][tx]==6) continue;
					}
					else if(i==2) {
						if(map[ty][tx]==2||map[ty][tx]==6||map[ty][tx]==7) continue;
					}
					else {
						if(map[ty][tx]==3||map[ty][tx]==4||map[ty][tx]==7) continue;
					}

					//System.out.println("갈수있는 곳 tx:"+tx+" ty:"+ty);
					visited[ty][tx]=true;
					q.add(new Pos(tx, ty));
				}
			}
			order++;
		}
		
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j]) ans++;
			}
		}
		return ans;
	}

}
