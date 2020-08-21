package BOJ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2931_가스관 {
	static int N,M;
	static int[][] map;
	static int srcx, srcy, dstx, dsty;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		map=new int[N][M];
		char[] tmp=new char[M];
		for(int i=0; i<N; i++) {
			tmp=sc.next().toCharArray();
			for(int j=0; j<M; j++) {
				switch (tmp[j]) {
				case '.':map[i][j]=0; break;
				case '|': map[i][j]=1; break;
				case '-': map[i][j]=2; break;
				case '+': map[i][j]=3; break;
				case '1': map[i][j]=4; break;
				case '2': map[i][j]=5; break;
				case '3': map[i][j]=6; break;
				case '4': map[i][j]=7; break;
				case 'M': srcx=j; srcy=i; map[i][j]=-1; break;
				case 'Z': dstx=j; dsty=i; map[i][j]=-2; break;
				default:
					break;
				}
			}
		}
		
		bfs();
	}
	static class Info {
		int x, y, v;

		public Info(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Info [x=" + x + ", y=" + y + ", v=" + v + "]";
		}
		
	}

	private static void bfs() {
		Queue<Info> q=new LinkedList<>();
		boolean[][] visited=new boolean[N][M];
		q.add(new Info(srcx, srcy, map[srcy][srcx]));
		visited[srcy][srcx]=true;
		

		int tx=0, ty=0;
		while(!q.isEmpty()) {
			Info tmp=q.poll();
			System.out.println(tmp.toString());
			
			for(int i=0; i<4; i++) {
				if(tmp.v==1 && (i==0||i==2)) continue;
				if(tmp.v==2 && (i==1||i==3)) continue;
				if(tmp.v==4 && i>=2) continue;
				if(tmp.v==5 && (i==1||i==2)) continue;
				if(tmp.v==6 && i<=1) continue;
				if(tmp.v==7 && (i==0||i==3)) continue;
				
				
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				if(tx<0||tx>=M||ty<0||ty>=N||visited[ty][tx]) continue;
				
				System.out.println("tx:"+tx+" ty:"+ty+" val:"+map[ty][tx]);
				
				if(map[ty][tx]==0) {
					System.out.println("in");
					//check
					int res=check(tx,ty);
					if(res!=0) {
						char ans='\u0000';
						switch (res) {
						case 1: ans='|'; break;
						case 2: ans='-'; break;
						case 3: ans='+'; break;
						case 4: ans='1'; break;
						case 5: ans='2'; break;
						case 6: ans='3'; break;
						case 7: ans='4'; break;
		
						default:
							break;
						}
						System.out.println((ty+1)+" "+(tx+1)+" "+ans);
						return;
					}
				}
				else {
					visited[ty][tx]=true;
					q.add(new Info(tx, ty, map[ty][tx]));
				}
					
				
			}
		}
		
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static int check(int x, int y) {
		int tx=0, ty=0;
		boolean[] dirs=new boolean[4];
		for(int i=0; i<4; i++) {
			tx=x+dx[i];
			ty=y+dy[i];
			if(tx<0||ty<0||tx>=M||ty>=N) continue;
			
			
			
			if(i==0) {
				if(map[ty][tx]==2 || map[ty][tx]==3||map[ty][tx]==6||map[ty][tx]==7) dirs[0]=true;
			}
			else if(i==1) {
				if(map[ty][tx]==1 || map[ty][tx]==3 || map[ty][tx]==5 || map[ty][tx]==6) dirs[1]=true;
			}
			else if(i==2) {
				if(map[ty][tx]==2 ||map[ty][tx]==3 || map[ty][tx]==4||map[ty][tx]==5) dirs[2]=true;			
			}
			else if(i==3) {
				if(map[ty][tx]==1 || map[ty][tx]==3 || map[ty][tx]==4 || map[ty][tx]==7) {
					dirs[3]=true;
				}
			}
			
			
			
		}
		
		System.out.println(Arrays.toString(dirs));
		
		int res=0;
		if(!dirs[0]&&dirs[1]&&!dirs[2]&&dirs[3]) res= 1;
		else if(dirs[0]&&!dirs[1]&&dirs[2]&&!dirs[3]) res= 2;
		else if(dirs[0]&&dirs[1]&&dirs[2]&&dirs[3]) res= 3;
		else if(dirs[0]&&dirs[1]&&!dirs[2]&&!dirs[3]) res= 4;
		else if(dirs[0]&&!dirs[1]&&!dirs[2]&&dirs[3]) res= 5;
		else if(!dirs[0]&&!dirs[1]&&dirs[2]&&dirs[3]) res= 6;
		else if(!dirs[0]&&dirs[1]&&dirs[2]&&!dirs[3]) res= 7;
		else res= 0;
		System.out.println("res:"+res);
		return res;
	}

}
