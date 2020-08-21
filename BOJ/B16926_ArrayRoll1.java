package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16926_ArrayRoll1 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(token.nextToken());
		int m=Integer.parseInt(token.nextToken());
		int r=Integer.parseInt(token.nextToken());
		int[][] map=new int[n][m];
		int[][] resultmap=new int[n][m];
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[][] visited=new boolean[n][m];
		int tmpn=n;
		int tmpm=m;
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int dir=0;
		int x=0, y=0;
		int tx=0, ty=0;
		int sx=0, sy=0;
		int ex=m, ey=n;
		for(int t=0; t<(n>m?n:m)/2; t++) {
			if(sx>=ex || sy>=ey) break;
			q.clear();
			q.add(map[sy][sx]);
			tx=sx; ty=sy;
			
			visited[ty][tx]=true;
			
			for(int i=0; i<4; i++) {
				tx+=dx[i];
				ty+=dy[i];
				while(tx>=sx&&ty>=sy&&tx<ex&&ty<ey&&!visited[ty][tx]) {
					q.add(map[ty][tx]);
					visited[ty][tx]=true;
					tx+=dx[i];
					ty+=dy[i];
				}
				tx-=dx[i];
				ty-=dy[i];
			}
			
			for(int i=0; i<r; i++) {
				int ttt=q.poll();
				q.offer(ttt);
			}
			tx=sx; ty=sy;
			resultmap[ty][tx]=q.poll();
			visited[ty][tx]=false;
			for(int i=0; i<4; i++) {
				tx+=dx[i];
				ty+=dy[i];
				while(tx>=sx&&ty>=sy&&tx<ex&&ty<ey&&visited[ty][tx]) {
//					q.add(map[ty][tx]);
					resultmap[ty][tx]=q.poll();
					visited[ty][tx]=false;
					tx+=dx[i];
					ty+=dy[i];
				}
				tx-=dx[i];
				ty-=dy[i];
			}
			
			sx+=1; sy+=1;
			ex-=1; ey-=1;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				System.out.print(resultmap[i][j]+" ");
			System.out.println();
		}
	}

}
