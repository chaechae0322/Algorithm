package beakjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2206_벽부수고이동하기 {
	static int N,M;
	static int[][] map;
	static boolean[][][] visited; 
	static class Node {
		int cnt, x,y;
		int used;
		
		public Node(int cnt, int x, int y, int used) {
			super();
			this.cnt = cnt;
			this.x = x;
			this.y = y;
			this.used = used;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt(); M=sc.nextInt();
		map=new int[N][M];
		visited=new boolean[2][N][M];
		String tmp="";
		for(int i=0; i<N; i++) {
			tmp=sc.next();
			for(int j=0; j<M; j++) {
				map[i][j]=tmp.charAt(j)-'0';
			}
		}
		if(N==1&&M==1) {
			System.out.println(1); return;
		}
		bfs();

	}
	private static void bfs() {
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(1, 0, 0, 0));
		visited[0][0][0]=true;
		
		int[] dx= {1,0,-1,0};
		int[] dy= {0,1,0,-1};
		int tx=0, ty=0, ans=-1;
		loop:while(!q.isEmpty()) {
			Node tmp=q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				if(tx<0||tx>=M||ty<0||ty>=N||visited[tmp.used][ty][tx]) continue;
				if(map[ty][tx]==1&&tmp.used==1)continue;
				
				if(tx==M-1&&ty==N-1) {
					ans=tmp.cnt+1;
					break loop;
				}
				if(map[ty][tx]==1 && tmp.used==0) {
					q.add(new Node(tmp.cnt+1, tx, ty, 1));
					visited[1][ty][tx]=true;
				}else {
					q.add(new Node(tmp.cnt+1, tx, ty, tmp.used));
					visited[tmp.used][ty][tx]=true;
				}
			}
		}
		System.out.println(ans);
		
	}

}
