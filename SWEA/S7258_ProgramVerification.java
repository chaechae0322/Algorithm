package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 2019.10.28
 * [swea] 혁진이의 프로그램 검증
 * bfs + 시뮬레이션
 */
public class S7258_ProgramVerification {
	static int n,m;
	static char[][] map;
	static class Node{
		int x,y,dir,mem;

		public Node(int x, int y, int dir, int mem) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.mem = mem;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + ", mem=" + mem + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int tc=Integer.parseInt(token.nextToken());

		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			n=Integer.parseInt(token.nextToken());
			m=Integer.parseInt(token.nextToken());

			map=new char[n][m];

			for(int i=0; i<n; i++) {
				map[i]=br.readLine().toCharArray();
			}

			Node start=new Node(0, 0, 0, 0);
			
			ansflag=false;
			bfs(start);
			if(ansflag) System.out.println("#"+t+" YES");
			else System.out.println("#"+t+" NO");
		}

	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static boolean ansflag;
	private static void bfs(Node start) {
		boolean[][][][] visited=new boolean[n][m][16][4];

		Queue<Node> q=new LinkedList<>();
		q.add(start);
		visited[start.y][start.x][start.mem][start.dir]=true;

		int tx=0, ty=0;
		int dir=0, mem=0;
		while(!q.isEmpty()) {
			Node tmp=q.poll();
			tx=tmp.x;
			ty=tmp.y;
			
			dir=tmp.dir;
			mem=tmp.mem;
			
			switch (map[tmp.y][tmp.x]) {
			case '<':
				
				tx+=dx[2];
				
				dir=2;
				
				if(tx<0) tx=m-1;
				
				
				break;
			case '>':
				tx+=dx[0];
				if(tx>=m) tx=0;
				dir=0;
				
				
				break;
			case 'v':
				ty+=dy[1];
				if(ty>=n) ty=0;
				dir=1;
				
				
				break;
			case '^':
				ty+=dy[3];
				if(ty<0) ty=n-1;
				dir=3;
				
				
				break;
			case '_':
				if(tmp.mem==0) {
					tx+=dx[0];
					if(tx>=m) tx=0;
					dir=0;
					
					
				}else {
					tx+=dx[2];
					if(tx<0) tx=m-1;
					dir=2;
					
				}
				break;
			case '|':
				if(tmp.mem==0) {
					ty+=dy[1];
					if(ty>=n) tx=0;
					dir=1;
					
				}else {
					ty+=dy[3];
					if(ty<0) ty=n-1;
					dir=3;
				}
				break;
			case '?':
				for(int i=0; i<4; i++) {
					tx=tmp.x+dx[i];
					ty=tmp.y+dy[i];
					
					if(tx<0||ty<0||tx>=m||ty>=n||visited[ty][tx][tmp.mem][i]) continue;
					
					visited[ty][tx][mem][i]=true;
					q.add(new Node(tx, ty, i, mem));
					
				}
				break;
			case '.':
				tx+=dx[dir];
				ty+=dy[dir];
				
				
				break;
			case '@':
				ansflag=true;
				return;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				tx+=dx[dir];
				ty+=dy[dir];
				mem=map[tmp.y][tmp.x]-'0';
				break;
			case '+':
				tx+=dx[dir];
				ty+=dy[dir];
				
				if(mem+1 == 16) mem=0;
				else mem+=1;
				break;
			case '-':
				tx+=dx[dir];
				ty+=dy[dir];
				
				if(mem-1 == -1) mem=15;
				else mem-=1;
				break;
			default:
				break;
			}

			if(map[tmp.y][tmp.x]!='?') {
				
				if(tx<0) tx=m-1;
				else if(tx==m) tx=0;
				if(ty<0) ty=n-1;
				else if(ty==n) ty=0;
				
				if(visited[ty][tx][mem][dir]) continue;
				
				
				visited[ty][tx][mem][dir]=true;
				q.add(new Node(tx, ty, dir, mem));
			}
		}


	}

}
