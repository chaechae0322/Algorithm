package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B19237_어른상어 {
	static class Info {
		int k, id;
		public Info() {}
		public Info(int k, int id){
			this.k = k;
			this.id = id;
		}
		@Override
		public String toString() {
			return "Info [k=" + k + ", id=" + id + "]";
		}
	}
	static class Shark {
		int x,y,d;
		public Shark() {

		}
		public Shark(int x, int y, int d) {
			this.x=x;
			this.y=y;
			this.d=d;
		}
		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
	static Info[][] map;
	static int[][] newpos;
	static Shark[] sharks;
	static boolean[] out;
	static int N, M, k;
	static int[][][] dirPriority; //상어 기준방향 우선순위
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		k=Integer.parseInt(token.nextToken());
		map=new Info[N][N];
		newpos=new int[N][N];
		sharks=new Shark[M+1];
		out=new boolean[M+1];
		dirPriority=new int[M+1][5][4];
		sharks[0]=new Shark();
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int tmp = Integer.parseInt(token.nextToken());
				if(tmp!=0) {
					map[i][j]=new Info(k, tmp);
					sharks[tmp]=new Shark(j, i, 0);
				}else {
					map[i][j]=new Info();
				}
			}
		}
		token = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			sharks[i].d=Integer.parseInt(token.nextToken());
		}
		for(int i=1; i<=M; i++) {
			for(int j=0; j<4; j++) {
				token = new StringTokenizer(br.readLine());
				for(int l=0; l<4; l++) {
					dirPriority[i][j+1][l]=Integer.parseInt(token.nextToken());
				}
			}
		}

		int t=0;
		boolean isend=true;
		while(t<=1000) {
			//System.out.println(Arrays.toString(out));
			isend=true;
			for(int i=2; i<=M; i++) {
				if(!out[i]) {
					isend=false;
					break;
				}
			}
			if(isend) {
				System.out.println(t);
				return;
			}
			
			move();
			clear();
			//move();
			
			System.out.println("time:"+ t);
			for(Shark s : sharks) {
				System.out.println(s.toString());
			}
			for(int i=0; i<N; i++) {
				System.out.println();
				for(int j=0; j<N; j++) {
					System.out.print(map[i][j].id+" "+map[i][j].k+"\t");
				}
			}
			
			t++;
		}
		System.out.println(-1);
	}
	static int[] dx= {0, 0, 0, -1, 1};
	static int[] dy= {0, -1, 1, 0, 0};
	private static void move() {
		ArrayList<int[]> list = new ArrayList<>();
		int tx=0, ty=0, td=0;
		int nx=0, ny=0, nd=0;
		for(int i=M; i>0; i--) {
			nx=0; ny=0; nd=0;
			if(out[i]) continue;

			//아무냄새 없는 곳
			for(int j=0; j<4; j++) {
				tx=sharks[i].x + dx[dirPriority[i][sharks[i].d][j]];
				ty=sharks[i].y + dy[dirPriority[i][sharks[i].d][j]];
				if(tx<0||tx>=N||ty<0||ty>=N)continue;
				if(map[ty][tx].id == 0) {
					System.out.println("Dd");
					nx=tx; ny=ty; nd=dirPriority[i][sharks[i].d][j];
					break;
				}
			}

			//자기 자신 영역
			if(nx==0&&ny==0&&nd==0) { 
				for(int j=0; j<4; j++) {
					tx=sharks[i].x + dx[dirPriority[i][sharks[i].d][j]];
					ty=sharks[i].y + dy[dirPriority[i][sharks[i].d][j]];
					if(tx<0||tx>=N||ty<0||ty>=N)continue;
					if(map[ty][tx].id == i) {
						nx=tx; ny=ty; nd=dirPriority[i][sharks[i].d][j];
						break;
					}
				}
			}
			
			System.out.println("ny:"+ny+" nx:"+nx+" nd:"+nd);
			sharks[i].x=nx;
			sharks[i].y=ny;
			sharks[i].d=nd;
			
			if(newpos[ny][nx]!=0) {
				out[newpos[ny][nx]]=true;
			}
			newpos[ny][nx]=i;
			list.add(new int[] {nx, ny});
		}
		
		for(int i=0; i<list.size(); i++) {
			int[] tmp = list.get(i);
			map[tmp[1]][tmp[0]].id=newpos[tmp[1]][tmp[0]];
			map[tmp[1]][tmp[0]].k=k+1;
			//newpos[tmp[1]][tmp[0]]=0;
		}
		for(int i=0; i<list.size(); i++) {
			int[] tmp = list.get(i);
			newpos[tmp[1]][tmp[0]]=0;
		}

	}
	private static void clear() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].k>0) {
					map[i][j].k--;
					if(map[i][j].k==0) {
						map[i][j].id=0;
					}
				}

			}
		}

	}

}
