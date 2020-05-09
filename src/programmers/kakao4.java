package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class kakao4 {

	public static void main(String[] args) {
		int[][] board = {
				//{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},
				//{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}
				//{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}
				{0,0,0},{0,0,0},{0,0,0}
		};
		System.out.println(solution(board));

	}
	static class Node{
		int x,y,d,c;

		public Node(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", c=" + c + "]";
		}
		
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static int solution(int[][] board) {
        int answer = 0;
        
        int n = board.length;
        int[][][] visited = new int[4][n][n];
        for(int i=0; i<4; i++)
        	for(int j=0; j<n; j++)
        		Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        
        Queue<Node> q= new LinkedList<>();
        visited[0][0][0]=0;
        visited[1][0][0]=0;
        visited[2][0][0]=0;
        visited[3][0][0]=0;
        
        q.add(new Node(0, 0, -1, 0));
        
        int tx=0, ty=0;
        while(!q.isEmpty()) {
        	Node tmp = q.poll();
        	
        	for(int i=0; i<4; i++) {
        		tx=tmp.x+dx[i];
        		ty=tmp.y+dy[i];
        		if(tx<0||ty<0||tx>=n||ty>=n||board[ty][tx]==1) continue;
        		
        		if(tmp.d == -1) {
        			visited[i][ty][tx]=tmp.c+100;
    				q.add(new Node(tx, ty, i, tmp.c+100));
    				continue;	
        		}
        		
        		if(Math.abs(i-tmp.d)==2 ||Math.abs(i-tmp.d)==0) { //직진 100
        			if(visited[i][ty][tx] > tmp.c+100) {
        				visited[i][ty][tx]=tmp.c+100;
        				q.add(new Node(tx, ty, i, tmp.c+100));
        			}
        		}else { //코너 500
        			if(visited[i][ty][tx] > tmp.c+600) {
        				visited[i][ty][tx]=tmp.c+600;
        				q.add(new Node(tx, ty, i, tmp.c+600));
        			}
        		}
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(visited[0][i][j]==Integer.MAX_VALUE)
        			System.out.print(0+"\t");
        		else System.out.print(visited[0][i][j]+"\t");
        	}
        	System.out.println();
        }
        
        int min = Integer.MAX_VALUE;
        min = Math.min(min, visited[0][n-1][n-1]);
        min = Math.min(min, visited[1][n-1][n-1]);
        min = Math.min(min, visited[2][n-1][n-1]);
        min = Math.min(min, visited[3][n-1][n-1]);
        answer = min;
        return answer;
    }

}
