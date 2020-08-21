package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2146_다리만들기 {
	
	static class Edge{
		int x,y,cost,id;

		public Edge(int x, int y, int cost, int id) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.id=id;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", y=" + y + ", cost=" + cost + ", id=" + id + "]";
		}
	}

	static int[][] map;
	static int[][] visited;
	static Queue<Edge> EdgeList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map=new int[n][n];
		visited=new int[n][n];
		EdgeList=new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		int id=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==1 && visited[i][j]==0) {
					bfs(j,i, ++id);
				}
			}
		}
		
		int tx=0, ty=0;
		int answer=Integer.MAX_VALUE;
		int step=0;
		boolean isflag=false;
		loop:while(!EdgeList.isEmpty()) {
			int qsize=EdgeList.size();
			
			for(int k=0; k<qsize; k++) {
				Edge tmp = EdgeList.poll();
				//System.out.println(tmp.toString());
				
				for(int i=0; i<4; i++) {
					tx = tmp.x+dx[i];
					ty = tmp.y+dy[i];
					
					if(tx<0||ty<0||tx>=n||ty>=n||visited[ty][tx]==Integer.MAX_VALUE) continue;
					if(visited[ty][tx]==tmp.id) continue;
					
					if(visited[ty][tx]==0) {
						visited[ty][tx]=tmp.id;
						EdgeList.add(new Edge(tx, ty, tmp.cost+1, tmp.id));
					}
					else if(visited[ty][tx]>0) {  //만났다.
						//System.out.println(visited[ty][tx]+" "+tmp.id);
						//System.out.println(i);
						//System.out.println("step:"+step);
						
						/*System.out.println("visited check");
						for(int ii=0; ii<n; ii++) {
							for(int jj=0; jj<n; jj++) {
								if(visited[ii][jj]==Integer.MAX_VALUE) System.out.print("0 ");
								else System.out.print(visited[ii][jj]+" ");
							}
							System.out.println();
						}*/
						isflag= true;
						
						if(visited[ty][tx]>tmp.id) {// 이전 step 꺼
							//answer = step*2;
							answer = Math.min(answer, step*2);
						}else { // 같은 step 꺼
							//answer = step*2+1;
							answer = Math.min(answer, step*2+1);
						}
						
						
						//break loop;
					}
				}
			}
			
			if(isflag) {
				break loop;
			}
			
			step++;
		}
		
		System.out.println(answer);

	}
	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	private static void bfs(int x, int y, int id) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[y][x]=Integer.MAX_VALUE;
		
		int tx=0, ty=0, n=visited.length;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int i=0; i<4; i++) {
				tx=tmp[0]+dx[i];
				ty=tmp[1]+dy[i];
				
				if(tx<0||ty<0||tx>=n||ty>=n||visited[ty][tx]==Integer.MAX_VALUE) continue;
				
				if(map[ty][tx]==1) {
					q.add(new int[] {tx, ty});
					visited[ty][tx]=Integer.MAX_VALUE;
				}
				else { //경계선
					EdgeList.add(new Edge(tmp[0], tmp[1], 0, id));

				}
				
			}
			
		}
	}

}
