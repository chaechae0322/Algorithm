package beakjoon;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class B1937_욕심쟁이판다 {
	static int n;
	static int[][] map;
	static long[][][] dp; // dir, y, x
	static class Node implements Comparable<Node>{
		int x,y,c;

		public Node(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Node arg0) {
			return this.c-arg0.c;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", c=" + c + "]";
		}
		
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n=sc.nextInt();
		map=new int[n][n];
		PriorityQueue<Node> pq=new PriorityQueue<>();
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
				pq.add(new Node(j, i, map[i][j]));
			}
				
		
		dp=new long[4][n][n];
		long ans=0; 
		int tx=0, ty=0;
		long res=0;
		while(!pq.isEmpty()) {
			Node tmp=pq.poll();
			System.out.println(tmp.toString());
			
			for(int i=0; i<4; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				if(tx<0||tx>=n||ty<0||ty>=n||tmp.c>=map[ty][tx]) continue;
				
				res=0;
				for(int j=0; j<4; j++) {
					if((j+2)%4==i)continue;
					res=Math.max(res, dp[j][tmp.y][tmp.x]+1);
				}
				dp[i][ty][tx]=res;
				ans=Math.max(ans, res);
				
				System.out.println("i:"+i);
				for(int j=0; j<n; j++) {
					for(int k=0; k<n; k++) {
						System.out.print(dp[i][j][k]+" ");
					}
					System.out.println();
				}
				System.out.println();
			}
		}
		System.out.println(ans+1);
	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};

}