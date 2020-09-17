package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
/*
 *  BFS + 열쇠착는경우에따라 다르게 visited (비트마스크)
 */
public class B17244_아맞다우산 {
	static int n,m;
	static char map[][];
	static HashMap<Integer, Integer> indexmap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in=br.readLine().split(" ");
		m=Integer.parseInt(in[0]); n=Integer.parseInt(in[1]);
		map=new char[n][m];
		int sx=0, sy=0, ex=0, ey=0;
		indexmap=new HashMap<Integer, Integer>();
		int x=0;
		for(int i=0; i<n; i++) {
			map[i]=br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(map[i][j]=='S') {
					sx=j; sy=i;
				}else if(map[i][j]=='X') {
					indexmap.put(i*m+j, (int) Math.pow(2, x++));
				}else if(map[i][j]=='E') {
					ex=j; ey=i;
				}
			}
		}
		int ans=bfs(sx, sy, ex, ey, x);
		System.out.println(ans);
	}
	static class Node{
		int x, y, bit, t;

		public Node(int x, int y, int bit, int t) {
			super();
			this.x = x;
			this.y = y;
			this.bit = bit;
			this.t = t;
		}
	}
	
	private static int bfs(int sx, int sy, int ex, int ey, int x) {
		boolean[][][] visited= new boolean[n][m][(int)Math.pow(2, x)];
		visited[sy][sx][0]=true; 
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(sx, sy, 0, 0));
		
		int dx[]= {1,0,-1,0}, dy[]= {0,1,0,-1}, tx=0, ty=0, tbit=0;
		while(!q.isEmpty()) {
			Node t=q.poll();
			for(int i=0; i<4; i++) {
				tx=t.x+dx[i];
				ty=t.y+dy[i];
				tbit=t.bit;
				if(tx<0||ty<0||tx>=m||ty>=n||map[ty][tx]=='#'||visited[ty][tx][tbit]) continue;
				if(indexmap.containsKey(ty*m+tx)) {
					if((indexmap.get(ty*m+tx)&tbit)==0)
						tbit+=indexmap.get(ty*m+tx);
				}
				if(tx==ex && ty==ey && tbit==(int)Math.pow(2, x)-1) {
					return t.t+1;
				}
				visited[ty][tx][tbit]=true;
				q.add(new Node(tx, ty, tbit, t.t+1));
			}
			
		}
		return 0;
	}

}
