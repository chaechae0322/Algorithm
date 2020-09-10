package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS
 */
public class B16569_회산쇄설류 {
	static int m,n,v, map[][];
	static ArrayList<Node> vlist;
	static class Node{
		int x,y,t;
		int sel;
		public Node(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
		public Node(int x, int y, int t, int sel) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
			this.sel = sel;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", t=" + t + ", sel=" + sel + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		m=Integer.parseInt(token.nextToken()); 
		n=Integer.parseInt(token.nextToken()); 
		v=Integer.parseInt(token.nextToken());
		map=new int[m][n]; vlist=new ArrayList<Node>();
		token = new StringTokenizer(br.readLine());
		int sy=Integer.parseInt(token.nextToken())-1; int sx=Integer.parseInt(token.nextToken())-1;
		for(int i=0; i<m; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		for(int i=0; i<v; i++) {
			token = new StringTokenizer(br.readLine());
			int y=Integer.parseInt(token.nextToken())-1; int x=Integer.parseInt(token.nextToken())-1;
			int t=Integer.parseInt(token.nextToken());
			vlist.add(new Node(x,y,t,2));

		}
		bfs(sx, sy);
	}
	static int[][] visited;
	static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	private static void bfs(int sx, int sy) {
		visited=new int[m][n];
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(sx, sy, 0, 1));
		
		visited[sy][sx]=1;//  1사람, 2화산
		for(int i=0; i<vlist.size(); i++) {
			q.add(vlist.get(i));
			visited[vlist.get(i).y][vlist.get(i).x]=2; // 화산
		}

		int time=1, tx=0, ty=0, ans=0, anst=0;
		ans=map[sy][sx]; anst=0;
		ArrayList<Node> save=new ArrayList<Node>();
		while(!q.isEmpty()) {
			int qsize=q.size(); 
			for(int turn=0; turn<qsize; turn++) {
				Node t=q.poll();
				if(time<=t.t) {
					q.add(t);
					continue;
				}
				for(int i=0; i<4; i++) {
					tx=t.x+dx[i]; ty=t.y+dy[i];
					if(tx<0||ty<0||tx>=n||ty>=m||visited[ty][tx]==3) continue;
					if(t.sel==1 && (visited[ty][tx]==1||visited[ty][tx]==2)) {
						continue;
					}
					if(t.sel==1) {
						visited[ty][tx]=1; 
						save.add(new Node(tx, ty, t.t, 1));
					}else {
						visited[ty][tx]=3; // 터짐 
						q.add(new Node(tx, ty, t.t, 2));
					}

				}
			}
			for(int i=0; i<save.size(); i++) {
				Node t=save.get(i);
				if(visited[t.y][t.x]==3) continue;
				q.add(t);
				if(ans<map[t.y][t.x]) {
					ans=map[t.y][t.x]; anst=time;
				}
			}
			save.clear();
			time++;
		}

		System.out.println(ans+" "+anst);
	}
}
