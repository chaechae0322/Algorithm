package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S17142_Lab3 {
	static int n,m;
	static int[][] map;
	static int[][] copymap;
	static ArrayList<int[]> list;
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		
		map=new int[n][n];
		copymap=new int[n][n];
		list=new ArrayList<>();
		
		int tmp=0;
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				tmp=Integer.parseInt(token.nextToken());
				if(tmp==2) {
					list.add(new int[] {j,i});
					map[i][j]=-1; //비활성바이러스
					
				}
				else
					map[i][j]=tmp;
			}
		}//
		
		ans=new int[m+1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		
		size=list.size();
		boolean[] visited=new boolean[size];
		int [] tt=null;
		for(int i=0; i<list.size(); i++) {
			tt=list.get(i);
			
			visited[i]=true;
			map[tt[1]][tt[0]]=2;
			dfs(0,1,visited);
			map[tt[1]][tt[0]]=-1;
			visited[i]=false;
		}
		
		if(ans[m]==Integer.MAX_VALUE)
			System.out.println("-1");
		else 
			System.out.println(ans[m]);
	}
	static int[] ans;
	private static void dfs(int pos, int depth, boolean[] visited) {
		int time=bfs(visited);
		if(ans[depth] < time) return;
		else {
			ans[depth]=time;
		}
		
		if(depth==m) return;
		
		int[] tt=null;
		for(int i=pos; i<size; i++) {
			if(!visited[i]) {
				tt=list.get(i);
				
				visited[i]=true;
				map[tt[1]][tt[0]]=2;
				dfs(i, depth+1, visited);
				map[tt[1]][tt[0]]=-1;
				visited[i]=false;
			}
		}
		
	}
	static class Pos{
		int x,y,d;

		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static int bfs(boolean[] visited) {
		copyMap();
		boolean[][] visited2=new boolean[n][n];
		Queue<Pos> q=new LinkedList<>();
		int[] tt=null;
		for(int i=0; i<size; i++) {
			if(visited[i]) {
				tt=list.get(i);
				q.add(new Pos(tt[0], tt[1], 0));
				visited2[tt[1]][tt[0]]=true;
			}
		}
		
		int tx=0, ty=0, time=0;
		while(!q.isEmpty()) {
			Pos tmp=q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				
				if(tx<0||ty<0||tx>=n||ty>=n||visited2[ty][tx]) continue;
				
				
				if(copymap[ty][tx]==-1) {
					visited2[ty][tx]=true;
					copymap[ty][tx]=tmp.d+1;
					q.add(new Pos(tx, ty, tmp.d+1));
				}
				
				else if(copymap[ty][tx]==0) {
					visited2[ty][tx]=true;
					copymap[ty][tx]=tmp.d+1;
					q.add(new Pos(tx, ty, tmp.d+1));
					time=tmp.d+1;
				}
			}
			
			
			/*for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++)
					System.out.print(copymap[i][j]+" ");
				System.out.println();
			}
			System.out.println();*/
		}
		
		boolean flag=true;
		loop: for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copymap[i][j]==0) {
					flag=false;
					break loop;
				}
			}	
		}
		
		if(flag) return time;
		else return Integer.MAX_VALUE;
	}
	
	private static void copyMap() {
		for(int i=0; i<n; i++)
			copymap[i]=map[i].clone();
	}

}
