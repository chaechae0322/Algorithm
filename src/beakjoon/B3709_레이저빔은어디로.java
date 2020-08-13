package beakjoon;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B3709_레이저빔은어디로 {
	static int[][] map; // 1: 거울  2: 레이저
	static int N;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int N = sc.nextInt();
			int s = sc.nextInt();
			map=new int[N+1+1][N+1+1];
			for(int i=0; i<s; i++) {
				map[sc.nextInt()][sc.nextInt()]=1;
			}
			int ly=sc.nextInt(); int lx=sc.nextInt();
			//map[ly][lx]=2;
			solve(ly, lx);
		}

	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void solve(int ly, int lx) {
		int tx=0, ty=0;
		if(ly==0) { // 밑으로
			tx=lx+dx[1];
			ty=ly+dy[1];
			while(tx>=1 && tx<=N && ty>=0 && ty<=N) {
				if(map[ty][tx]==1) {
					break;
				}
				tx+=dx[1];
				ty+=dy[1];
			}
			if(tx<=0 || ty<=0 || tx>=N+1 || ty>=N+1) { // 벗어나는거
				
			}
			
		}else if(ly==N+1) { // 위로
			tx=lx+dx[3];
			ty=ly+dy[3];
		}else if(lx==0) { // 오늘쪽으로
			tx=lx+dx[0];
			ty=ly+dy[0];
		}else { // 왼쪽으로
			tx=lx+dx[2];
			ty=ly+dy[2];
		}
		
	}

}
