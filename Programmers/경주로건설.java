package Programmers;

import java.util.Arrays;
/*
 * DFS 
 * 방문체크 4방향
 */
public class 경주로건설 {

	public static void main(String[] args) {
		int[][] map= {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.println(solution(map));

	}
	static int n, m[][], visited[][][], ans;
    public static int solution(int[][] board) {
        int answer = 0;
        n=board.length;
        m=board;
        visited=new int[n][n][4];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++)
        	Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        }
        ans=Integer.MAX_VALUE;
        Arrays.fill(visited[0][0], 0);
        dfs(0,0,-1,0); 
        answer=ans;
        return answer;
    }
    static int[] dx= {1,0,-1,0}, dy= {0,1,0,-1};
	private static void dfs(int x, int y, int d, int c) {
		int tx=0, ty=0, tc=0;
		for(int i=0; i<4; i++) {
 			if(d==-1||d%2==i%2) tc=100;
			else tc=600;
			tx=x+dx[i]; ty=y+dy[i];
			if(tx<0||ty<0||tx>=n||ty>=n||m[ty][tx]==1) continue;
			
			
			if(visited[ty][tx][i]>c+tc) { // 더 작아야 가능
				if(tx==n-1&&ty==n-1) {
					ans=Math.min(ans, c+tc);
				}
				visited[ty][tx][i]=c+tc;
				dfs(tx, ty, i, c+tc);
			}
		}
		
	}

}
