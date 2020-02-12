package beakjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class B15683_감시 {
	static int N,M;
	static int[][] map;
	static ArrayList<Node> list;

	static class Node {
		int x,y,num;

		public Node(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", num=" + num + "]";
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		map=new int[N][M];
		list=new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]>0&&map[i][j]<6) {
					list.add(new Node(j, i, map[i][j]));
				}
			}
		}
		int[] dirs=new int[list.size()];

		ans=Integer.MAX_VALUE;

		dfs(0,dirs);
		System.out.println(ans);
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int ans;
	private static void dfs(int idx, int[] dirs) {
		if(idx==list.size()) {
			ans=Math.min(ans, action(dirs));
			return;
		}

		int end=4;
		if(list.get(idx).num==2) end=2;
		else if(list.get(idx).num==5) end=1;


		for(int i=0; i<end; i++) {
			dirs[idx]=i;
			dfs(idx+1, dirs);
		}


	}
	public static int action(int[] dirs) {
		int clonemap[][]=new int[N][M];
		for(int i=0; i<N; i++)
			clonemap[i]=map[i].clone();
		
		for(int idx=0; idx<list.size(); idx++) {
			int num=list.get(idx).num;
			int x=list.get(idx).x;
			int y=list.get(idx).y;
			int dir=dirs[idx];
			int tx=x, ty=y;
			
			switch (num) {
			case 1:
				tx=x+dx[dir];
				ty=y+dy[dir];
				while(tx>=0&&ty>=0&&tx<M&&ty<N&&clonemap[ty][tx]!=6) {
					if(clonemap[ty][tx]==0) clonemap[ty][tx]=7;

					tx+=dx[dir];
					ty+=dy[dir];
				}
				break;
			case 2:
				for(int i=0; i<2; i++) {
					dir=(dir+2)%4;
					tx=x+dx[dir];
					ty=y+dy[dir];
					
					while(tx>=0&&ty>=0&&tx<M&&ty<N&&clonemap[ty][tx]!=6) {
						if(clonemap[ty][tx]==0) clonemap[ty][tx]=7;

						tx+=dx[dir];
						ty+=dy[dir];
					}
				}
				break;
			case 3:
				for(int i=0; i<2; i++) {
					
					tx=x+dx[(dir+i)%4];
					ty=y+dy[(dir+i)%4];
					
					while(tx>=0&&ty>=0&&tx<M&&ty<N&&clonemap[ty][tx]!=6) {
						if(clonemap[ty][tx]==0) clonemap[ty][tx]=7;

						tx+=dx[(dir+i)%4];
						ty+=dy[(dir+i)%4];
					}
				}
				break;
			case 4:
				for(int i=0; i<3; i++) {
					
					tx=x+dx[(dir+i)%4];
					ty=y+dy[(dir+i)%4];
					
					while(tx>=0&&ty>=0&&tx<M&&ty<N&&clonemap[ty][tx]!=6) {
						if(clonemap[ty][tx]==0) clonemap[ty][tx]=7;

						tx+=dx[(dir+i)%4];
						ty+=dy[(dir+i)%4];
					}
				}
				break;
			case 5: 
				for(int i=0; i<4; i++) {
					dir=i;
					tx=x+dx[dir];
					ty=y+dy[dir];
					
					while(tx>=0&&ty>=0&&tx<M&&ty<N&&clonemap[ty][tx]!=6) {
						if(clonemap[ty][tx]==0) clonemap[ty][tx]=7;

						tx+=dx[dir];
						ty+=dy[dir];
					}
				}
			default:
				break;
			}
		}
		
		
		int cnt=0;
		for(int i=0; i<N; i++) 
			for(int j=0; j<M; j++) 
				if(clonemap[i][j]==0) cnt++;
			
		
		
		return cnt;
	}

}
