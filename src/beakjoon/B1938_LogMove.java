import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


class Log{
	Pos[] pos;
	int status;
	int cnt;
	
	
	public Log() {
		pos=new Pos[3];
	}

	

	public Log(Pos[] pos, int status, int cnt) {
		super();
		this.pos = pos;
		this.status = status;
		this.cnt = cnt;
	}



	@Override
	public String toString() {
		return "Log [pos=" + Arrays.toString(pos) + ", status=" + status + "]";
	}
	
}
class Pos {
	int x, y;
	
	public Pos() {
	}

	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pos [x=" + x + ", y=" + y + "]";
	}
	
	
}
public class B1938_LogMove {
	static int n;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());

		map=new int[n][n];
		
		Log start = new Log();
		start.pos=new Pos[3];
		
		int startidx=0;
		
		int tmp=0;
		for(int i=0; i<n; i++) {
			String line= br.readLine();
//			System.out.println(line);
			for(int j=0; j<line.length(); j++) {
				if(line.charAt(j)=='B') {
					start.pos[startidx]=new Pos();
					start.pos[startidx].y=i; //y
					start.pos[startidx].x=j; //x
					
					tmp=0;
					startidx++;
				}
				else if(line.charAt(j)=='1') tmp=1;
				else if(line.charAt(j)=='0') tmp=0;
				else if(line.charAt(j)=='E') tmp=2; //도착지
				map[i][j]=tmp;
			}
		}//
		
		Pos c=start.pos[1];
		if(c.y-1 == start.pos[0].y) start.status=1;
		else start.status=2;
		
		bfs(start);
		
	}
	static int[] dx= {1,0,-1,0,0};
	static int[] dy= {0,1,0,-1,0};
	static boolean[][][] visited;
	private static void bfs(Log start) {
		visited= new boolean[2][n][n];  //세로로올때 1, 가로로올때 2
		
		Queue<Log> q = new LinkedList<>();
		
		q.add(start);
		visited[start.status-1][start.pos[1].y][start.pos[1].x]=true;
		
		int ans=0;
		while(!q.isEmpty()) {
			Log tmp = q.poll();
			//System.out.println(tmp);
			
			if(check(tmp)) {
				ans=tmp.cnt;
				break;
			}
			
			boolean ff=true;
			for(int i=0; i<5; i++) {
				ff=isPossible(tmp, i);
				//System.out.println("i:"+i+" isPossible:"+ff);
				if(ff) {
					int nstatus=tmp.status;
					if(i==4) {
						if(tmp.status==1) nstatus=2;
						else nstatus=1;
					}
					q.add(new Log(move(tmp, i), nstatus, tmp.cnt+1));
				}
			}
			
		}
		System.out.println(ans);
		
	}
	private static boolean check(Log tmp) {
		Pos[] tt=tmp.pos;
		
		for(int i=0; i<3; i++) {
			if(map[tt[i].y][tt[i].x]!=2) {
				return false; 
			}
		}
		return true;
	}
	private static Pos[] move(Log tmp, int dir) {
		Pos[] res = new Pos[3];

		
		if(dir<=3) {
			for(int i=0; i<3; i++) {
				res[i]=new Pos();
				res[i].x=tmp.pos[i].x+dx[dir];
				res[i].y=tmp.pos[i].y+dy[dir];
			}
			visited[tmp.status-1][res[1].y][res[1].x]=true;
		}
		else {
			for(int i=0; i<3; i++)
				res[i]=new Pos();
			if(tmp.status==1) { //세로
				res[0].x=tmp.pos[0].x-1;
				res[0].y=tmp.pos[0].y+1;
				
				res[2].x=tmp.pos[2].x+1;
				res[2].y=tmp.pos[2].y-1;
				
				
			}
			else { //가로
				res[0].x=tmp.pos[0].x+1;
				res[0].y=tmp.pos[0].y-1;
				
				res[2].x=tmp.pos[2].x-1;
				res[2].y=tmp.pos[2].y+1;
				
			}
			res[1]=tmp.pos[1];
			visited[(tmp.status+1)%2][res[1].y][res[1].x]=true;
		}
		
		//visited[][res[1].y][res[1].x]=dir==4?tmp.status==1?2:1:tmp.status;
		//System.out.println("move res:"+Arrays.toString(res));
		return res;
	}
	static int[] dxx= {1,0,-1,0,-1,1,-1,1};
	static int[] dyy= {0,1,0,-1,-1,-1,1,1};
	private static boolean isPossible(Log tmp, int dir) {
		int tx=0, ty=0;
		Pos[] tt= tmp.pos;
		
		if(dir<=3) {
			for(int i=0; i<3; i++) {
				tx=tt[i].x+dx[dir];
				ty=tt[i].y+dy[dir];
				
				if(tx<0||ty<0||tx>=n||ty>=n||map[ty][tx]==1) return false;
				if(i==1 && visited[tmp.status-1][ty][tx]) {
					return false;
				}
				
			}
		}
		else {
			
			int nstatus=tmp.status;
			
			if(tmp.status==1) nstatus=2;
			else nstatus=1;
			
			
			if(visited[nstatus-1][tt[1].y][tt[1].x]) return false;
			for(int i=0; i<8; i++) {
				
				tx=tt[1].x+dxx[i];
				ty=tt[1].y+dyy[i];
				
				//System.out.println("tx:"+tx+" ty:"+ty);
				
				if(tx<0||ty<0||tx>=n||ty>=n||map[ty][tx]==1) return false;
			}
		}
		return true;
	}

}
