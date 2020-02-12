import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17069_PipeMove2 {
	static long[][][] dp;
	static int n;
	static int[][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		map=new int[n][n];
		visited=new boolean[3][n][n];
		/*for(int i=0; i<3; i++) {
			for(int j=0; j<n; j++)
				Arrays.fill(dp[i][j], -1);
		}*/
		dp=new long[3][n][n];
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		
		
		
		
		//long ans=dp[0][0][1]+dp[1][0][1]+dp[2][0][1];
		System.out.println(dfs(1,0,0,0));

	}
	static int[] dx= {1,1,0};
	static int[] dy= {0,1,1};
	private static long dfs(int x, int y, int depth, int status) {
		//System.out.println("x:"+x+" y:"+y+" depth:"+depth+" status:"+status);
		if(dp[status][y][x]!=0) {
			return dp[status][y][x];
		}
		if(x==n-1 && y==n-1) {
			dp[status][n-1][n-1]=1;
			return 1;
		}
		
		int tx=0, ty=0;
		for(int i=0; i<3; i++) {
			if(status==0 && i==2) continue;
			else if(status==2 && i==0) continue;
			
			tx=x+dx[i];
			ty=y+dy[i];
			
			if(tx<0||ty<0||ty>=n||tx>=n) continue;
			if(map[ty][tx]==1) continue;
			if(!check(x,y,i)) continue;
			
			
			 
				
			dp[status][y][x]+=dfs(tx,ty,depth+1,i);
			
			
		}
		
		/*System.out.println("DP 확인");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		return dp[status][y][x];
	}
	private static boolean check(int x, int y, int i) {
		if(i==0) {
			return (x+dx[0]>=0&&x+dx[0]<n&&y+dy[0]>=0&&y+dy[0]<n&&map[y+dy[0]][x+dx[0]]!=1);
		}
		else if(i==1) {
			return (x+dx[0]>=0&&x+dx[0]<n&&y+dy[0]>=0&&y+dy[0]<n&&map[y+dy[0]][x+dx[0]]!=1
					&&x+dx[1]>=0&&x+dx[1]<n&&y+dy[1]>=0&&y+dy[1]<n&&map[y+dy[1]][x+dx[1]]!=1
					&&x+dx[2]>=0&&x+dx[2]<n&&y+dy[2]>=0&&y+dy[2]<n&&map[y+dy[2]][x+dx[2]]!=1);
		}
		else {
			return (x+dx[2]>=0&&x+dx[2]<n&&y+dy[2]>=0&&y+dy[2]<n&&map[y+dy[2]][x+dx[2]]!=1);
		}
	}

}
