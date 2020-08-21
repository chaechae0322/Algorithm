
package BOJ;

import java.awt.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B17837_새로운게임2 {
	static class Mal{
		int x, y, d;

		public Mal(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Mal [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
		
	}
	static class Info {
		ArrayList<Integer> list;

		public Info(ArrayList<Integer> list) {
			super();
			this.list = list;
		}

		@Override
		public String toString() {
			return "Info [list=" + list + "]";
		}
		
	}
	
	static int N,K;
	static int[][] map;
	static Info[][] infomap;
	
	static ArrayList<Mal> mal;
	static int[] dx= {0,1,-1,0,0};
	static int[] dy= {0,0,0,-1,1};
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); K=sc.nextInt();
		
		map=new int[N][N];
		infomap = new Info[N][N];
		
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				infomap[i][j]=new Info(new ArrayList<>());
			}
		
		mal = new ArrayList<>();
		int x=0, y=0;
		for(int i=1; i<=K; i++) {
			y=sc.nextInt()-1; x=sc.nextInt()-1;
			mal.add(new Mal(x, y, sc.nextInt()));
			infomap[y][x].list.add(i);
		}
		
		
		int turn = 1;
		int tx=0, ty=0, td=0;
		Deque<Integer> carrier = new LinkedList<>();
		loop:while(turn<=1000) {
			for(int malturn=1; malturn<=K; malturn++) {
				Mal cur = mal.get(malturn-1);
				td=cur.d;
				tx=cur.x+dx[cur.d];
				ty=cur.y+dy[cur.d];
				
				if(isBlue(tx, ty)) {
					td=cur.d%2==1?cur.d+1:cur.d-1;
					tx=cur.x+dx[td];
					ty=cur.y+dy[td];
					
					
					if(isBlue(tx, ty)) {
						cur.d = cur.d%2==1?cur.d+1:cur.d-1;
						continue;
					}
				}
				mal.get(malturn-1).d=td;
				
				
				int idx=0;
				int orisize = infomap[cur.y][cur.x].list.size();
				
				for(int i=0; i<orisize; i++) {
					if(infomap[cur.y][cur.x].list.get(i) == malturn) {
						idx=i; break;
					}
				}

				for(int i=0; i<orisize-idx; i++) {
					carrier.add(infomap[cur.y][cur.x].list.get(idx));
					infomap[cur.y][cur.x].list.remove(idx);
				}
				
				if(map[ty][tx]==0) { // 흰색
					while(!carrier.isEmpty()) {
						idx = carrier.pollFirst();
						mal.get(idx-1).x=tx;
						mal.get(idx-1).y=ty;
						infomap[ty][tx].list.add(idx);
					
					}
					
				}else if(map[ty][tx]==1) { // 빨간색
					while(!carrier.isEmpty()) {
						idx = carrier.pollLast();
						mal.get(idx-1).x=tx;
						mal.get(idx-1).y=ty;
						infomap[ty][tx].list.add(idx);
					}
				}

				if(infomap[ty][tx].list.size()>=4) {
					break loop;
				}
			}
			turn++;

		}
		
		if(turn<=1000) System.out.println(turn);
		else System.out.println(-1);
		

	}
	private static boolean isBlue(int x, int y) {
		if(x<0||y<0||x>=N||y>=N||map[y][x]==2) return true; 
		return false;
	}

}
