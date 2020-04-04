package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {
	
	public static void main(String[] args) {
		solution(6,4, 
				new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, 
			{0, 0, 0, 3}, {0, 0, 0, 3}});

	}
	
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static boolean[][] visited;
	public static int bfs(int x, int y, int m, int n, int[][] picture) {
		Queue<int[]> q=new LinkedList<>();
		q.add(new int[] {x,y});
		visited[y][x]=true;
		
		int tx=0, ty=0, cnt=1;
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				if(tx<0||tx>=n||ty<0||ty>=m||visited[ty][tx]) continue;
				if(picture[ty][tx]!=picture[tmp[1]][tmp[0]]) continue;
				
				q.add(new int[] {tx,ty});
				visited[ty][tx]=true;
				cnt++;
			}
		}
		
		return cnt;
	}

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(picture[i][j]!=0 && !visited[i][j]) {
					//System.out.println("seed x:"+j+" y:"+i);
					++numberOfArea;
					maxSizeOfOneArea=Math.max(maxSizeOfOneArea, bfs(j,i,m,n,picture));

				}
			}
		}
		
		
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		System.out.println(Arrays.toString(answer));
		return answer;
	}

}
