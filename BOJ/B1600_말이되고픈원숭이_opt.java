
package BOJ;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B1600_말이되고픈원숭이_opt{
	static int K,N,M;
	static int[][] map;
	static boolean[][][] check;
	static class Node{
		int x,y,k;
		int cnt;

		public Node(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", k=" + k + ", cnt=" + cnt + "]";
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K=sc.nextInt(); M=sc.nextInt(); N=sc.nextInt();
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
			}
		}

		check=new boolean[K+1][N][M];
		/*for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				for(int k=0; k<8; k++)
					Arrays.fill(check[i][j][k], Integer.MAX_VALUE);*/

		if(N==1 && M==1) {
			System.out.println("0");
			return;
		}
		
		bfs();

	}
	static int[] dxx= {1,2,2,1,-1,-2,-2,-1};
	static int[] dyy= {-2,-1,1,2,2,1,-1,-2};
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void bfs() {
		Queue<Node> q=new LinkedList<>();

		for(int i=0; i<K+1; i++)
			check[i][0][0]=true;

		//check[0][0][]=true;
		//q.add(new Node(0,0,0,0));
		q.add(new Node(0,0,0,0));
		int tx=0, ty=0;
		int ans=Integer.MAX_VALUE;
		loop:while(!q.isEmpty()) {
			Node tmp=q.poll();

			System.out.println(tmp.toString());

			//mal
			if(tmp.k < K) {
				for(int i=0; i<8; i++) {

					tx=tmp.x+dxx[i];
					ty=tmp.y+dyy[i];
					if(tx<0||ty<0||tx>=M||ty>=N||map[ty][tx]==1||check[tmp.k+1][ty][tx]) continue;
					

					if(tx==M-1&&ty==N-1) {
						//ans=Math.min(ans, tmp.k+1);
						ans=tmp.cnt+1;
						break loop;
					}

					q.add(new Node(tx, ty, tmp.k+1, tmp.cnt+1));
					check[tmp.k+1][ty][tx] = true;

				}
			}

			//monkey
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				System.out.println(tx+" "+ty);
				if(tx<0||ty<0||tx>=M||ty>=N||check[tmp.k][ty][tx]) continue;
				if(map[ty][tx]==1) continue;

				if(tx==M-1&&ty==N-1) {
					//ans=Math.min(ans, tmp.k+1);
					ans=tmp.cnt+1;
					break loop;
				}

				q.add(new Node(tx, ty, tmp.k, tmp.cnt+1));
				check[tmp.k][ty][tx]=true;
			}

		}
		if(ans==Integer.MAX_VALUE) ans=-1;
		System.out.println(ans);
	}

}
