package Programmers;

import java.util.LinkedList;
import java.util.Queue;
/*
 * BFS
 */
public class 프렌즈4블록 {

	public static void main(String[] args) {
		//System.out.println(solution(4,5, new String[] {"CCBDE", "AAADE", "AAABF", "CCBBF"}));
		System.out.println(solution(6,6, new String[] {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));

	}
	static char[][] map;
	static boolean[][] visited;
	static int M,N;
	public static int solution(int m, int n, String[] board) {
		M=m; N=n;
		map=new char[m][n];
		for(int i=0; i<board.length; i++) {
			map[i]=board[i].toCharArray();
		}
		
		int answer = 0;
		while(true) {
			visited=new boolean[m][n];
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j]!='\u0000' && !visited[i][j] && check(j,i)) {
						bfs(j,i);
					}
				}
			}
			int cnt=0;
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					if(visited[i][j]) cnt++;
				}
			}
			answer+=cnt;
			if(cnt==0) break;
      
			// move
			move();

		}
		return answer;
	}
	private static void move() {
		Queue<Character> q=new LinkedList<>();
		for(int j=0; j<N; j++) {
			for(int i=M-1; i>=0; i--) {
				if(map[i][j]!='\u0000' && !visited[i][j]) {
					q.add(map[i][j]);
				}
			}
			
			for(int i=M-1; i>=0; i--) {
				if(!q.isEmpty()) {
					map[i][j]=q.poll();
				}else {
					map[i][j]='\u0000';
				}
			}
		}
		
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q=new LinkedList<>();
		visited[y][x]=true;
		q.add(new int[] {x,y});
		int tx=0, ty=0;
		while(!q.isEmpty()) {
			int[] t=q.poll();
			
			if(check(t[0],t[1])) {
				// add
				for(int i=0; i<4; i++) {
					tx=t[0]+dx[i]; ty=t[1]+dy[i];
					if(!visited[ty][tx]) {
						visited[ty][tx]=true;
						q.add(new int[] {tx, ty});
					}
				}
			}
		}

	}
	static int[] dx= {0,1,1,0}, dy= {0,0,1,1};
	private static boolean check(int x, int y) {
		char ref=map[y][x];
		int tx=0, ty=0;
		for(int i=0; i<4; i++) {
			tx=x+dx[i]; ty=y+dy[i];
			if(tx<0||ty<0||tx>=N||ty>=M||map[ty][tx]=='\u0000'||ref!=map[ty][tx]) return false;
		}
		return true;
	}
}
