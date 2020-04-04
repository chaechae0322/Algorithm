import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14502_Lab1 {
	static int n,m;
	static int[][] map;
	static int[][] copymap;
	static boolean[][] visited;
	static ArrayList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		map=new int[n][m];
		copymap=new int[n][m];
		list=new ArrayList<>();
		
		int tmp=0;
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				tmp=Integer.parseInt(token.nextToken());
				if(tmp==2) {
					list.add(new int[] {j,i});
				}
				map[i][j]=tmp;
			}
		}//
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(j,i,1);
					map[i][j]=0;
				}
			}
		}
		
		System.out.println(ans);

	}
	static int ans;
	private static void dfs(int x, int y, int depth) {
		if(depth==3) {
			//bfs
			copyMap();
			int num = bfs();
			ans=Math.max(num, ans);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					dfs(j,i,depth+1);
					map[i][j]=0;
				}
			}
		}
		
	}
	private static void copyMap() {
		for(int i=0; i<n; i++) {
			copymap[i]=map[i].clone();
		}
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int count;
	private static int bfs() {
//		if(count==20) System.exit(0);
//		count++;
		/*for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(copymap[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		
		Queue<int[]> q = new LinkedList<>();
		visited=new boolean[n][m];
		
		int[] tmp=null;
		for(int i=0; i<list.size(); i++) {
			tmp=list.get(i);
			q.add(tmp);
			visited[tmp[1]][tmp[0]]=true;
		}
		
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			tmp=q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				
				if(tx<0||ty<0||tx>=m||ty>=n||visited[ty][tx]) continue;
				
				if(copymap[ty][tx]==0) {
					copymap[ty][tx]=2;
					visited[ty][tx]=true;
					q.add(new int[] {tx, ty});
				}
			}
		}
		
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(copymap[i][j]==0) cnt++;
			}
		}
		
		return cnt;
	}

}
