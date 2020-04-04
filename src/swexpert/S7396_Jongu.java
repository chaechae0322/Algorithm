import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S7396_Jongu {
	static int n,m;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int tc=Integer.parseInt(token.nextToken());
		
		for(int t=1; t<=tc; t++) {
			token=new StringTokenizer(br.readLine());
			n=Integer.parseInt(token.nextToken());
			m=Integer.parseInt(token.nextToken());
			
			map=new char[n][m];
			visited=new boolean[n][m];
			
			for(int i=0; i<n; i++) {
				String line=br.readLine();
				map[i]=line.toCharArray();
			}
			
			bfs(0,0);
			System.out.println("#"+t+" "+sb);
		}
		

	}
	static class Pos implements Comparable<Pos>{
		int x,y,d;
		
		public Pos(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Pos o) {
			return map[this.y][this.x]>map[o.y][o.x]?1:map[this.y][this.x]==map[o.y][o.x]?0:-1;
		}

		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", d=" + d + "]";
		}
	}
	static int[] dx= {1,0};
	static int[] dy= {0,1};
	static StringBuilder sb;
	private static void bfs(int x, int y) {
		sb = new StringBuilder();
		Queue<Pos> q=new LinkedList<>();
		q.add(new Pos(x, y, 0));
		visited[y][x]=true;
		
		ArrayList<Character> list=new ArrayList<>();
		//list.add(map[y][x]);
		sb.append(map[y][x]);
	
		int level=0;
		int tx=0, ty=0;
		
		ArrayList<Pos> alpa=new ArrayList<>();
		Pos first=null;
		Pos tmp=null;
		while(!q.isEmpty()) {
			
			if(level != q.peek().d) {

				Collections.sort(alpa);
				for(int i=0; i<alpa.size(); i++) {
					System.out.println(alpa.get(i));
				}
					

				first=alpa.get(0);
				sb.append(map[first.y][first.x]);
				
				q.clear();
				q.add(first);
				for(int i=1; i<alpa.size(); i++) {
					tmp=alpa.get(i);
					if(map[first.y][first.x] == map[tmp.y][tmp.x]) {
						q.add(tmp);
					}else {
						break;
					}
				}
				alpa.clear();
				//tmp=q.poll();
			}
			
			tmp=q.poll();

			//alpa.add(new Pos(tmp.x, tmp.y, tmp.d));
			level=tmp.d;
			
			for(int i=0; i<2; i++) {
				tx=tmp.x+dx[i];
				ty=tmp.y+dy[i];
				
				if(tx<0||ty<0||tx>=m||ty>=n||visited[ty][tx]) continue;
				
				visited[ty][tx]=true;
				q.add(new Pos(tx, ty, tmp.d+1));
				alpa.add(new Pos(tx, ty, tmp.d+1));
				
			}
		}
		
	}

}
