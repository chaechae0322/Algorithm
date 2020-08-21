package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17406_ArrayRoll4 {
	static int n,m,k;
	static int[][] map;
	static int[][] resultmap;
	static class Oper{
		int r,c,s;

		public Oper(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Oper [r=" + r + ", c=" + c + ", s=" + s + "]";
		}
		
	}
	static Oper[] opers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		m=Integer.parseInt(token.nextToken());
		k=Integer.parseInt(token.nextToken());
		
		map=new int[n][m];
		resultmap=new int[n][m];
		opers=new Oper[k];
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++)
				map[i][j]=Integer.parseInt(token.nextToken());
		}
		for(int i=0; i<k; i++) {
			token = new StringTokenizer(br.readLine());
			opers[i]=new Oper(Integer.parseInt(token.nextToken()), 
					Integer.parseInt(token.nextToken()), 
					Integer.parseInt(token.nextToken()));
		}
		ans=Integer.MAX_VALUE;
		perm(0);
		System.out.println(ans);
	}
	static int ans;
	private static void perm(int pos) {
		if(pos==k) {			
			ans=Math.min(ans, rolling());
			return;
		}
		
		for(int i=pos; i<k; i++) {
			swap(i,pos);
			perm(pos+1);
			swap(i,pos);
		}
		
	}
	private static void swap(int i, int pos) {
		int r=opers[i].r;
		int c=opers[i].c;
		int s=opers[i].s;
		int rr=opers[pos].r;
		int cc=opers[pos].c;
		int ss=opers[pos].s;
		opers[i].r=rr;
		opers[i].c=cc;
		opers[i].s=ss;
		opers[pos].r=r;
		opers[pos].c=c;
		opers[pos].s=s;
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static int rolling() {
		for(int i=0; i<n; i++)
			resultmap[i]=map[i].clone();
		
		int sx=0, sy=0, ex=m, ey=n;
		int tx=0, ty=0;
		int tmpn=n, tmpm=m;
		boolean[][] visited= new boolean[n][m];
		int r=0, c=0, s=0;
		int pre=0, now=0;
		int ttm=0, ttn=0;
		for(int t=0; t<k; t++) {
			visited= new boolean[n][m];
			r=opers[t].r-1;
			c=opers[t].c-1;
			s=opers[t].s;
			
			sx=c-s;
			sy=r-s;
			ex=c+s+1;
			ey=r+s+1;
			
			tmpm=ex-sx;
			tmpn=ey-sy;
			ttm=tmpm;
			ttn=tmpn;
			for(int nn=0; nn<(ttn>ttm?ttn:ttm)/2; nn++) {
				if(sx>=ex || sy>=ey) break;
				
				tx=sx; 
				ty=sy;
				pre=resultmap[ty][tx];
				visited[ty][tx]=true;
				for(int i=0; i<4; i++) {
					tx+=dx[i];
					ty+=dy[i];
					while(tx>=sx&&ty>=sy&&tx<ex&&ty<ey&&!visited[ty][tx]) {
                        visited[ty][tx]=true;
						now=resultmap[ty][tx];
						resultmap[ty][tx]=pre;
						pre=now;
						
						tx+=dx[i];
						ty+=dy[i];
					}
					if(i==3) resultmap[ty][tx]=pre;
					tx-=dx[i];
					ty-=dy[i];
				}
				sx+=1;
				sy+=1;
				ex-=1;
				ey-=1;
				
				tmpm=ex-sx;
				tmpn=ey-sy;
			}
        }
		int sum=0, min=Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			sum=0;
			for(int j=0; j<m; j++) {
				sum+=resultmap[i][j];
			}
			min=Math.min(min, sum);
		}
		return min;
	}

}
