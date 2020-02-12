import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PapingPaping{
	static int n;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(br.readLine().trim());
		
		for(int t=1; t<=tc; t++) {
			n=Integer.parseInt(br.readLine().trim());
			map=new char[n][n];
			visited=new boolean[n][n];
			
			for(int i=0; i<n; i++) {
				String line=br.readLine().trim();
				for(int j=0; j<n; j++) {
					map[i][j]=line.charAt(j);
				}
			}// 입력완료
			
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j] && map[i][j]=='.') { //방문 안했고 지뢰아닐때
						//입접 8 방향 검사
						boolean isSafe=true;
						a: for(int ii=-1; ii<=1; ii++) {
							for(int jj=-1; jj<=1; jj++) {
								if(i+ii == i && j+jj == j) continue;
								if(i+ii<0 || i+ii>=n || j+jj<0 || j+jj >=n) continue;
								
								if(map[i+ii][j+jj]=='*') {
									isSafe=false;
									break a;
								}
							}
						}
						
						if(isSafe) {
							cnt++;
							dfs(j,i);
						}
					}
				}
			}
			
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!visited[i][j] && map[i][j]=='.')
						cnt++;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	private static void dfs(int x, int y) {
		Stack<pos> st=new Stack<>();
		visited[y][x]=true;
		st.add(new pos(x,y));
		
		while(!st.isEmpty()) {
			pos now=st.pop();
			
			boolean isSafe=true;
			a:for(int i=-1; i<=1; i++) {
				for(int j=-1; j<=1; j++) {
					
					if(i+now.y == now.y && j+now.x == now.x) continue;
					if(i+now.y<0 || i+now.y>=n || j+now.x<0 || j+now.x >=n) continue;
					
					if(map[now.y+i][now.x+j]=='*') {
						isSafe=false;
						break a;
					}
				}
			}
			
			if(isSafe) {
				for(int i=-1; i<=1; i++) {
					for(int j=-1; j<=1; j++) {
						
						if(i+now.y == now.y && j+now.x == now.x) continue;
						if(i+now.y<0 || i+now.y>=n || j+now.x<0 || j+now.x >=n) continue;
						
						if(!visited[i+now.y][j+now.x]) {
							visited[i+now.y][j+now.x]=true;
							st.add(new pos(j+now.x, i+now.y));
						}
					}
				}
			}
		}
	}
}