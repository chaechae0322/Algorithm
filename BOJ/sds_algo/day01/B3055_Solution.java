package BOJ.sds_algo.day01;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B3055_Solution {
	static int R, C;
	static char[][] map;
	static Queue<int[]> q;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt(); C=sc.nextInt();
		map=new char[R][C];
		q=new LinkedList<>();
		dp= new int[R][C];
		boolean answerFind=false;
		
		int sx=0, sy=0;
		List<int[]> waterList=new ArrayList<>();
		for(int i=0; i<R; i++) {
			String input=sc.next();
			map[i]=input.toCharArray();
			for(int j=0; j<C; j++) {
				//char tmp=input.charAt(j);
				if(map[i][j]=='S') {
					//sx=j; sy=i;
					q.add(new int[] {j, i, 0, 1});
					dp[i][j]=1;
				}else if(map[i][j]=='*') {
					//mx=j; my=i;
					waterList.add(new int[] {j, i, 0, 2});
					dp[i][j]=1;
				}
			}
		}
		q.addAll(waterList);
		
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			System.out.println(Arrays.toString(tmp));
			if(map[tmp[1]][tmp[0]]=='D') {
				System.out.println(dp[tmp[1]][tmp[0]]);
				answerFind=true;
				break;
			}
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				if(tx<0||ty<0||tx>=C||ty>=R||map[ty][tx]=='X') continue;
				if(tmp[3]==1) {
					if(dp[ty][tx] == 0 && checkSafe(tx, ty)) {
						q.add(new int[] {tx, ty, tmp[2]+1, 1});
						dp[ty][tx]=dp[tmp[1]][tmp[0]]+1;
					}
				}else {
					if(map[ty][tx]!='.') continue;
					q.add(new int[] {tx, ty, tmp[2]+1,2});
					map[ty][tx]='*';
				}
			}
		}
		if(!answerFind) System.out.println("KAKTUS");
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static boolean checkSafe(int x, int y) {
		if(map[y][x]=='D') return true;
		if(map[y][x]=='.') {
			//boolean flag=true;
			for(int i=0; i<4; i++) {
				int tx=x+dx[i];
				int ty=y+dy[i];
				if(tx<0||ty<0||tx>=C||ty>=R||map[ty][tx]=='*') return false;
			}
			return true;
		}else {
			return false;
		}
	}

}
