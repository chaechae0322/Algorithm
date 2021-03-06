package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1194_MoonLetsGo {
	static char[][] map;
	static boolean[][][] visited;
	static int N,M;
	static class Node{
		int x,y,prevdir;
		int cnt;
		boolean[] keyList; //abcdef
		
		public Node(int x, int y, int prevdir, boolean[] keyList, int cnt) {
			this.x = x;
			this.y = y;
			this.prevdir=prevdir;
			this.keyList = keyList;
			this.cnt=cnt;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new char[N][M];
		visited=new boolean[64][N][M]; //0 a b c d e f
		int sx=0, sy=0;
		for(int i=0; i<N; i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				if(map[i][j]=='0') {
					sy=i; sx=j;
				}
			}
		}
		//System.out.println("sx:"+sx+" sy:"+sy);
		bfs(sx,sy);
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void bfs(int sx, int sy) {
		Queue<Node> q =new LinkedList<>();
		q.add(new Node(sx, sy, -1, new boolean[6], 0));
		visited[0][sy][sx]=true;
		
		int tx=0, ty=0;
		int ans=-1;
		boolean diff=false;
		boolean[] tmpList=new boolean[6];
		int idx=0;
		loop:while(!q.isEmpty()) {
			Node tmp=q.poll();
			idx=0;
			for(int i=0; i<6; i++) {
				if(tmp.keyList[i]) idx+=Math.pow(2, i);
			}
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				
				if(tx>=M||tx<0||ty>=N||ty<0)continue;
				if(map[ty][tx]=='#') continue;
				if(visited[idx][ty][tx]) continue;
				
				
				if(map[ty][tx]>='A'&& map[ty][tx]<='F') {
					if(!tmp.keyList[map[ty][tx] + 32 -'a']) continue;
				}
				
				tmpList=tmp.keyList.clone();
				if(map[ty][tx]=='1') {
					ans=tmp.cnt+1;
					break loop;
				}
				else if(map[ty][tx]>='a'&& map[ty][tx]<='f') {
					if(!tmpList[map[ty][tx]-'a']) {
						tmpList[map[ty][tx]-'a']=true;
						idx+=Math.pow(2, map[ty][tx]-'a');
					}
					
					q.add(new Node(tx, ty, -1, tmpList, tmp.cnt+1));
				}
				else { //map�� .�϶�
					q.add(new Node(tx, ty, i, tmpList, tmp.cnt+1));
				}
				
				
				idx=0;
				for(int j=0; j<6; j++) {
					if(tmpList[j]) idx+=Math.pow(2, j);
				}
				visited[idx][ty][tx]=true;
			}
			
		}
		System.out.println(ans);
		
	}

}
