import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17070_PipeMove1 {
	static int n;
	static int[][] map;
	static long[][] dp;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token =new StringTokenizer(br.readLine());
		n=Integer.parseInt(token.nextToken());
		map=new int[n][n];
		dp=new long[n][n];
		visited=new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		
		
		System.out.println(dfs(1,0,0,0)); //0:가로, 1:세로, 2:대각선
		
	}
	static int[] dx= {1,1,0};
	static int[] dy= {0,1,1};
	private static long dfs(int x, int y, int pos, int state) {
		//System.out.println("x:"+x+" y:"+y+" state:"+state);
		
		if(dp[y][x]!=0) return dp[y][x];
		if(x==n-1 && y==n-1) {
			//System.out.println("도착함");
			dp[n-1][n-1]=1;
			return 1; 
		}
		
		
		
		int st=state==0?0:state==1?0:1;
		int ed=state==0?2:state==1?3:3;
		int tx=0, ty=0;
		for(int i=st; i<ed; i++) {
			//System.out.println("i:"+i);
			tx=x+dx[i];
			ty=y+dy[i];
			
			if(tx<0||ty<0||tx>=n||ty>=n) continue;
			if(map[ty][tx]==1) continue;
			else if(i==1 && !check(x,y,i)) {
				continue;
			}
			if(ty==n-1&&tx<n-1&&i==2)continue;
			if(tx==n-1&&ty<n-1&&i==0)continue;
			
			if(visited[ty][tx]) {
				dp[y][x]+=dp[ty][tx];
				if(i==0) {
					if(ty+dy[2]<n) dp[y][x]-=dp[ty+dy[2]][tx];
//					if(tx+dx[1]<n && ty+dy[1]<n) dp[y][x]+=dp[ty+dy[1]][tx+dx[1]];
				}else if(i==2) {
					if(tx+dx[0]<n) dp[y][x]-=dp[ty][tx+dx[0]];
				}
				
				continue;
			}
			
			
			
			
			
			
			
			
			visited[ty][tx]=true;
			dp[y][x]+=dfs(tx,ty,pos,i);
			
		}
		
		/*System.out.println("DP 확인");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
		System.out.println();*/
		return dp[y][x];
	}
	private static boolean check(int x, int y, int state) {
		//System.out.println("check() x:"+x+" y:"+y+" state:"+state);
		int tx=0, ty=0;
		for(int i=0; i<3; i++) {
			tx=x+dx[i];
			ty=y+dy[i];
			
			//if(tx<0||ty<0||tx>=n||ty>=n) return false;
			if(map[ty][tx]==1) return false;
		}
		return true;
	}

}
