import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1767_Processor {
	static int n;
	static int[][] map;
	static int[][] copymap;
	static Pos[] core;
	static int corenum;
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + "]";
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			n=Integer.parseInt(token.nextToken());
			map=new int[n][n];
			copymap=new int[n][n];
			core=new Pos[12]; //최대 12개

			corenum=0;
			offset=0;
			int tmp=0;
			for(int i=0; i<n; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					tmp=Integer.parseInt(token.nextToken());
					map[i][j]=tmp;
					if(tmp==1) {
						if(i==0||j==0||i==n-1||j==n-1) {
							offset++;
							continue;
						}
						core[corenum++]=new Pos(j,i);
					}
					
				}
			}
			
			maxcore=offset;
			minlen=Integer.MAX_VALUE;
			
			int[] dirs=new int[corenum];
			dfs(0,dirs,offset);
			
			if(minlen==Integer.MAX_VALUE) minlen=0;
			System.out.println("#"+t+" "+minlen);
		}
	}
	static int offset;
	static int maxcore;
	static int minlen;
	private static void dfs(int pos, int[] dirs, int num) {
		if(pos==corenum) {
			
			int res=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]==2) res++;
				}
			}
			
			if(num>maxcore) {
				maxcore=num;
				minlen=res;
			}
			else if(num==maxcore)
				minlen=Math.min(res, minlen);
		
			return;
		}

		int x=core[pos].x;
		int y=core[pos].y;
		int tx=0, ty=0;
		for(int i=0; i<5; i++) {
			if(!check(pos, i)) continue;
			dirs[pos]=i;
			tx=x+dx[i];
			ty=y+dy[i];

			while(i>0&&tx>=0&&ty>=0&&tx<n&&ty<n) {
			
				map[ty][tx]=2;
				tx+=dx[i];
				ty+=dy[i];
			}
			dfs(pos+1,dirs, i==0?num:num+1);
			
			tx-=dx[i];
			ty-=dy[i];
			while(tx!=x || ty!=y) {
				map[ty][tx]=0;
				tx-=dx[i];
				ty-=dy[i];
			}
			
			dirs[pos]=i;
		}
	}
	private static boolean check(int pos, int i) {
		if(i==0) return true;
		
		int x=core[pos].x;
		int y=core[pos].y;
		
		int tx=x+dx[i];
		int ty=y+dy[i];

		while(tx>=0&&ty>=0&&tx<n&&ty<n) {
			if(map[ty][tx]>=1) return false;

			tx+=dx[i];
			ty+=dy[i];
			
		}
		return true;
	}
	static int[] dx= {0,1,0,-1,0};
	static int[] dy= {0,0,1,0,-1};


}
