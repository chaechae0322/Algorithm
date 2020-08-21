package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18809_Gaaaaaaaaaarden {
	static class Point{
		int x, y;
		int color;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int color) {
			super();
			this.x = x;
			this.y = y;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", color=" + color + "]";
		}



	}

	static int[][] map;
	static int N,M,G,R;
	static ArrayList<Point> area;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		G=Integer.parseInt(token.nextToken());
		R=Integer.parseInt(token.nextToken());

		area = new ArrayList<>();
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
				if(map[i][j]==2)
					area.add(new Point(j, i));
			}
		}

		boolean[] check= new boolean[area.size()];
		setSeed(0, 0, check);
		System.out.println(ans);

	}
	private static void setSeed(int idx, int cnt, boolean[] checkSeed) {
		
		if(cnt == G+R) {
			boolean[] check=new boolean[area.size()];
			setGreen(0,0,checkSeed, check);
		}
		if(idx==area.size()) return;
		

		checkSeed[idx]=true;
		setSeed(idx+1, cnt+1, checkSeed);
		checkSeed[idx]=false;
		setSeed(idx+1, cnt, checkSeed);

	}
	private static void setGreen(int idx, int cnt, boolean[] checkSeed, boolean[] checkGreen) {
		if(cnt == G) {
			simulate(checkSeed, checkGreen);
			return;
		}

		
		if(idx == area.size()) return;
		
		if(!checkSeed[idx]) {
			setGreen(idx+1, cnt, checkSeed, checkGreen);
			return;
		}


		checkGreen[idx]=true;
		setGreen(idx+1, cnt+1, checkSeed, checkGreen);
		checkGreen[idx]=false;
		setGreen(idx+1, cnt, checkSeed, checkGreen);

	}

	static int[] dx= {1,0,-1,0};
	static int[] dy= {0,1,0,-1};
	static int ans;
	private static void simulate(boolean[] checkSeed, boolean[] checkGreen) {
		
		System.out.println("checkSeed");
		System.out.println(Arrays.toString(checkSeed));
		
		System.out.println("checkGreen");
		System.out.println(Arrays.toString(checkGreen));
		
		Queue<Point> q= new LinkedList<>();
		boolean[][] visited=  new boolean[N][M];

		for(int i=0; i<checkSeed.length; i++) {
			if(checkSeed[i]) {
				if(checkGreen[i]) q.add(new Point(area.get(i).x, area.get(i).y, 100)); // green seed
				else q.add(new Point(area.get(i).x, area.get(i).y, 200)); // red seed

				visited[area.get(i).y][area.get(i).x] = true;
			}
		}

		int tx=0, ty=0;
		int step=1;
		int flower=0;
		ArrayList<Point> list = new ArrayList<>();
		int[][] visited2 = new int[N][M];
		while(!q.isEmpty()) {
			int qsize = q.size();
			list = new ArrayList<>();
			for(int tt=0; tt<qsize; tt++) {
				Point tmp = q.poll();
				if(visited2[tmp.y][tmp.x]>=300) continue;
				
				
				System.out.println(tmp.toString());

				for(int i=0; i<4; i++) {
					tx=tmp.x+dx[i];
					ty=tmp.y+dy[i];

					if(tx<0||ty<0||tx>=M||ty>=N||map[ty][tx]==0||visited[ty][tx]) continue;

					if(visited2[ty][tx] == tmp.color || visited2[ty][tx] >= 300) {
						continue;
					}
					
					//visited[ty][tx]=true;
					q.add(new Point(tx, ty, tmp.color));
					visited2[ty][tx]+=tmp.color;
					
					if(visited2[ty][tx]>=300) flower++;
					list.add(new Point(tx, ty, tmp.color));




				}
			}
			
			/*System.out.println("visited2");
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(visited2[i][j]+" ");
				}
				System.out.println();
			}*/
			
			for(int i=0; i<list.size(); i++) {
				visited[list.get(i).y][list.get(i).x]=true;
			}

			/*System.out.println("step:"+step);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(visited2[i][j]!=0) {
						if(visited2[i][j]==100 || visited2[i][j]==200) {
							System.out.println("visited create");
							visited[i][j]=true;
							q.add(new Point(j, i, visited2[i][j]));
						}else {
							System.out.println("flower x:"+j+" y:"+i);
							flower++;
							visited[i][j]=true;
						}
						visited2[i][j]=0;
					}

				}
			}*/

			step++;
		}

		ans = Math.max(ans, flower);
		return;

	}

}
