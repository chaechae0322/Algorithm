package Programmers.lineTest;

public class Solution4 {

	public static void main(String[] args) {
		//int[][] maze= {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
		int[][] maze= {{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}};
		System.out.println(solution(maze));
		
	}
    public static int solution(int[][] maze) {
        int answer = 0;
        int n=maze.length, m=maze[0].length;
        int d=1, td=0, dx[]= {1,0,-1,0}, dy[]= {0,1,0,-1}, x=0, y=0, tx=0, ty=0;
        
        while(x!=m-1 || y!=n-1) {
        	
        	td=d-1;
        	if(td<0) td=3;
        	for(int i=0; i<4; i++) {
        		tx=x+dx[(td+i)%4];
        		ty=y+dy[(td+i)%4];
        		if(tx<0||ty<0||tx>=m||ty>=n||maze[ty][tx]==1) continue;
        		
        		x=tx; y=ty; d=(td+i)%4;
            	answer++;
            	break;
        	}
        }
        return answer;
    }

}
