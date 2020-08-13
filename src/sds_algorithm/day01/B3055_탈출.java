package sds_algorithm.day01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B3055_탈출 {

	static int R, C;
	static char[][] map;
	static Queue<int[]> q;
	static int[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt(); C=sc.nextInt();
		int sx=0, sy=0;
		int mx=0, my=0;
		map=new char[R][C];
		q=new LinkedList<>();
		visited= new int[R][C];
		for(int i=0; i<R; i++) {
			String input=sc.next();
			map[i]=input.toCharArray();
			for(int j=0; j<C; j++) {
				//char tmp=input.charAt(j);
				if(map[i][j]=='S') {
					sx=j; sy=i;
				}else if(map[i][j]=='*') {
					//mx=j; my=i;
					q.add(new int[] {j, i, 0, 2});
					visited[i][j]=2;
				}
			}
		}
		for(int i=0; i<R; i++)
			System.out.println(Arrays.toString(map[i]));
		
		bfs(sx, sy);
		if(ans==0) {
			System.out.println("KAKTUS");
		}else
			System.out.println(ans);
	}
	static int ans;
	private static void bfs(int sx, int sy) {
		//Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {sx, sy, 0, 1}); //고슴도치
		
		
		visited[sy][sx]=1;
		
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			System.out.println(Arrays.toString(tmp));
			/*if(tmp[3]==1) {
				if(visited[tmp[1]][tmp[0]]==2) continue;
			}*/
			
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				if(tx<0||ty<0||tx>=C||ty>=R||map[ty][tx]=='X'||visited[ty][tx]>1) continue;
				if(tmp[3]==1) { //고슴도치일때
					if(map[ty][tx]=='D') {
						ans=tmp[2]+1;
						return;
					}
					if(visited[ty][tx]==0) {
						visited[ty][tx]=1;
						q.add(new int[] {tx, ty, tmp[2]+1, 1});
					}
				}else { // 물일때
					if(map[ty][tx]=='D') {
						System.out.println("cjcjcjcj");
						continue;
					}
					visited[ty][tx]=2;
					q.add(new int[] {tx, ty, tmp[2]+1, 2});
				}
				
			}
		}
	}

}
