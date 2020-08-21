package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17069_PipeMove2_re {
	static long[][][] dp;
	static int n;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(token.nextToken());
		map=new int[n][n];
		
		dp=new long[3][n][n];
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}//
		
		//dp[0][0][2]=1; // 첼 처음 가로방향
		//dp[1][1][1]=1;
		dp[0][0][1]=1;
		//dp[1][0][1]=1;
		int tx=0, ty=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				// 가로 방향
				
				// 가로 혹은 대각선
				//
				
				if(j+dx[0]<n && map[i][j+dx[0]]==0) {
					//System.out.println("dd");
					dp[0][i][j+dx[0]]+=dp[0][i][j];
				}
				tx=j+dx[1];
				ty=i+dy[1];
				if(tx>=0&&ty>=0&&ty<n&&tx<n) {
					if(map[ty][tx-1]==0 && map[ty][tx]==0 && map[ty-1][tx]==0) {
						dp[1][ty][tx]+=dp[0][i][j];
					}
				}
				
				// 세로 방향
				//cache[y + 1][x][1] += cache[y][x][1] + cache[y][x][2];
				if(i+dy[2]<n && map[i+dy[2]][j]==0) {
					dp[2][i+dy[2]][j]+=dp[2][i][j];
				}
				tx=j+dx[1];
				ty=i+dy[1];
				if(tx>=0&&ty>=0&&ty<n&&tx<n) {
					if(map[ty][tx-1]==0 && map[ty][tx]==0 && map[ty-1][tx]==0) {

						dp[1][ty][tx]+=dp[2][i][j];
					}
				}
				
				// 대각선 방향
				//cache[y + 1][x + 1][2] += cache[y][x][0] + cache[y][x][1] + cache[y][x][2];
				if(j+dx[0]<n && map[i][j+dx[0]]==0) {
					dp[0][i][j+dx[0]]+=dp[1][i][j];
				}
				if(i+dy[2]<n && map[i+dy[2]][j]==0) {
					dp[2][i+dy[2]][j]+=dp[1][i][j];
				}
				tx=j+dx[1];
				ty=i+dy[1];
				if(tx>=0&&ty>=0&&ty<n&&tx<n) {
					if(map[ty][tx-1]==0 && map[ty][tx]==0 && map[ty-1][tx]==0) {
						dp[1][ty][tx]+=dp[1][i][j];
					}
				}
				
				//System.out.println("dp[0]["+i+"]["+j+"]: "+dp[0][i][j]);
				//System.out.println("dp[1]["+i+"]["+j+"]: "+dp[1][i][j]);
				//System.out.println("dp[2]["+i+"]["+j+"]: "+dp[2][i][j]);
			}
		}
		
		/*System.out.println("DP 확인");
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(dp[2][i][j]+" ");
			}
			System.out.println();
		}*/
		
		System.out.println(dp[0][n-1][n-1]+dp[1][n-1][n-1]+dp[2][n-1][n-1]);
	}
	static int[] dx= {1,1,0};
	static int[] dy= {0,1,1};

}
