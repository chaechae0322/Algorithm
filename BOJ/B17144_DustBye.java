package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17144_DustBye {
	static int n,m,T;
	static int[][] map;
	static int upy, downy;
	static ArrayList<Pos> seed;
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			//this.a = a;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		T=Integer.parseInt(token.nextToken());
		map=new int[n][m];
		copymap=new int[n][m];
		seed=new ArrayList<>();
		
		int tmp=0;
		for(int i=0; i<n; i++) {
			token=new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				tmp=Integer.parseInt(token.nextToken());
				map[i][j]=tmp;
				if(tmp==-1) {
					if(upy!=0) downy=i;
					else upy=i;
					//map[i][j]=0;
				}
				else if(tmp>0) {
					seed.add(new Pos(j, i));
				}
			}
		}//
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++)
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
		
		System.out.println(bfs());
		
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int[][] copymap;
	private static int bfs() {
		Queue<Pos> q=new LinkedList<>();
		for(int i=0; i<seed.size(); i++)
			q.add(seed.get(i));
		
		int qsize=0;
		Pos tmp=null;
		
		int tx=0, ty=0;
		int a=0;
		for(int t=0; t<T; t++) {
			qsize=q.size();
			copyMap();
			for(int s=0; s<qsize; s++) {
				tmp=q.poll();
				a=copymap[tmp.y][tmp.x];
				
				for(int i=0; i<4; i++) {
					tx=tmp.x+dx[i];
					ty=tmp.y+dy[i];
					
					if(tx<0||ty<0||tx>=m||ty>=n) continue;
					if(map[ty][tx]==-1) continue;
					
					if(map[ty][tx]>=0) { //확산
						map[tmp.y][tmp.x]-=a/5;
						map[ty][tx]+=a/5;
						//q.add(new Pos(tx, ty));
					}
				}
			}
			
			aircleaner();
			
			
			q.clear();
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) { 
					if(map[i][j]>0) {
						q.add(new Pos(j, i));
					}
					
				}
			}
			
			System.out.println("after "+(t+1)+"초");
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) { 
					System.out.print(map[i][j]+" ");
					
				}
				System.out.println();
			}
			
			
			
			
		}
		
		int cnt=0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) 
				if(map[i][j]>0) cnt+=map[i][j];
		
		
		return cnt;
	}
	private static void copyMap() {
		for(int i=0; i<n; i++)
			copymap[i]=map[i].clone();
		
	}
	private static void aircleaner() {
		//up
		int tx=0,ty=upy;
		int pre=0, now=0;
		for(int i=0; i<4; i++) {
			tx+=dx[i];
			ty+=dy[(i+2)%4];
			
			while(tx>=0&&ty>=0&&tx<m&&ty<=upy) {
				now=map[ty][tx];
				map[ty][tx]=pre;
				pre=now;
				
				tx+=dx[i];
				ty+=dy[(i+2)%4];
			}
			
			tx-=dx[i];
			ty-=dy[(i+2)%4];
			
		}
		
		//down
		tx=0; ty=downy;
		pre=0; now=0;
		for(int i=0; i<4; i++) {
			tx+=dx[i];
			ty+=dy[i];
			
			while(tx>=0&&ty>=downy&&tx<m&&ty<n) {
				now=map[ty][tx];
				map[ty][tx]=pre;
				pre=now;
				
				tx+=dx[i];
				ty+=dy[i];
			}
			
			tx-=dx[i];
			ty-=dy[i];
			
		}
		
		map[upy][0]=-1;
		map[downy][0]=-1;
	}

}
