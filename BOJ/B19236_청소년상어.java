package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B19236_청소년상어 {
	static class Info{
		int x,y,d;

		public Info(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
	}
	static boolean[] eat;
	static int ans, dx[]= {0,-1,-1,-1,0,1,1,1}, dy[]= {-1,-1,0,1,1,1,0,-1};
	static Info[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int[][] map=new int[4][4]; list=new Info[17]; eat=new boolean[17];
		for(int i=0; i<4; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) {
				int a=Integer.parseInt(token.nextToken());
				int b=Integer.parseInt(token.nextToken())-1;
				list[a]=new Info(j,i,b);
				map[i][j]=a;
			}
		}
		
		shx=0; shy=0;
		eat[map[0][0]]=true;
		dfs(0,0,map[0][0], map);
		
		System.out.println(ans);
	}
	static int shx, shy, cnt;
	private static void dfs(int x, int y, int c, int[][] map) {
		System.out.println("x:"+x+" y:"+y+" c:"+c);
		cnt++; if(cnt>=10) return;
		ans=Math.max(ans, c);
		
		
		int tx=x, ty=y, d=list[map[y][x]].d;
		int[][] newmap=move(map);
		print(newmap);
		
		
		for(int i=0; i<4; i++) {
			tx=x+dx[d]*(i+1);
			ty=y+dy[d]*(i+1);
			if(tx<0||ty<0||tx>=4||ty>=4) continue;
			if(eat[newmap[ty][tx]]) continue;
			
			eat[newmap[ty][tx]]=true;
			shx=tx; shy=ty;
			dfs(tx, ty, c+newmap[ty][tx], newmap);
			shx=x; shy=y;
			eat[newmap[ty][tx]]=false;
		}
	}
	private static int[][] move(int[][] map) {
		int[][] nmap=new int[4][4];
		for(int i=0; i<4; i++) nmap[i]=map[i].clone();
		int tx=0, ty=0, x=0, y=0, d=0;
		for(int turn=1; turn<=16; turn++) {
			System.out.println(turn+"번째 물고기 움직인다~ 시작방향:"+dir(list[turn].d));
			if(eat[turn]) continue;
			
			x=list[turn].x; y=list[turn].y; d=list[turn].d;
			for(int i=0; i<8; i++) {
				tx=x+dx[(d+i)%8];
				ty=y+dy[(d+i)%8];
				System.out.println("방향:"+dir((d+i)%8));
				if(tx<0||ty<0||tx>=4||ty>=4||(tx==shx&&ty==shy)) {
					continue;
				}
				
				System.out.println(nmap[ty][tx]+"번 물고기랑 자리바꿈"+"tx:"+tx+" ty:"+ty+" 바뀐 방향:"+dir((d+i)%8));
				// swap
				Info t=list[turn];
				list[turn]=new Info(tx, ty, (d+i)%8);
				list[nmap[ty][tx]]=new Info(t.x, t.y, list[nmap[ty][tx]].d);
				nmap[t.y][t.x]=nmap[ty][tx];
				nmap[ty][tx]=turn;
				
				print(nmap);
				break;
			}
		}
		
		return nmap;
	}
	public static void print(int[][] map) {
		System.out.println("--------------------------");
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(j==shx&&i==shy) System.out.print("-1\t");
				else System.out.print(map[i][j]+"\t");
			}
			System.out.println();
		}
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(j==shx&&i==shy) System.out.print("-1\t");
				else System.out.print(dir(list[map[i][j]].d)+"\t");
			}
			System.out.println();
		}
		
	}
	public static String dir(int d) {
		String res="";
		switch (d) {
		case 0:
			res="위쪽";
			break;
		case 1:
			res="위동쪽";
			break;
		case 2:
			res="동쪽";
			break;
		case 3:
			res="아래동쪽";
			break;
		case 4:
			res="아래쪽";
			break;
		case 5:
			res="아래서쪽";
			break;
		case 6:
			res="서쪽";
			break;
		case 7:
			res="위서쪽";
			break;
		default:
			break;
		}
		return res;
	}
}
