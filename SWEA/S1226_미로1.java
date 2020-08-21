package SWEA;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S1226_미로1 {
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int test=0; test<10; test++) {
			sc.next();
			map=new char[16][16];
			
			for(int i=0; i<16; i++) {
				map[i]=sc.next().toCharArray();
			}
			
			flag=false;
			bfs(1,1);
			
			System.out.print("#"+(test+1)+" ");
			if(flag) System.out.println(1);
			else System.out.println(0);
		}

	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static boolean flag;
	private static void bfs(int sx, int sy) {
		Queue<int[]> q= new LinkedList<>();
		boolean[][] visited= new boolean[16][16];
		visited[1][1]=true;
		q.add(new int[] {sx, sy});
		
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				
				if(tx<0||ty<0||tx>=16||ty>=16||map[ty][tx]=='1'||visited[ty][tx]) continue;
				
				if(map[ty][tx]=='3') {
					flag= true;
					return;
				}
				
				visited[ty][tx]=true;
				q.add(new int[] {tx, ty});
			}
		}
		
	}

}
