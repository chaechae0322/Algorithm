package BOJ.sds_algo.day02;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096_내려가기 {
	static int N;
	static int[][][] dp; // 0: small, 1: big
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		N=Integer.parseInt(token.nextToken());
		map=new int[N][3];
		dp=new int[2][N][3];
		for(int i=0; i<N; i++) {
			token = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				map[i][j]=Integer.parseInt(token.nextToken());
			}
		}
		dp[0][0]=map[0].clone();
		dp[1][0]=map[0].clone();
		int min=0;
		int max=0;
		for(int i=1; i<N; i++) {
			//min=Math.min(dp[0][i-1][0], Math.min(dp[0][i-1][1], dp[0][i-1][2]));
			//max=Math.max(dp[1][i-1][0], Math.max(dp[1][i-1][1], dp[1][i-1][2]));
			for(int j=0; j<3; j++) {
				if(j==0) {
					min=Math.min(dp[0][i-1][0], dp[0][i-1][1]);
					max=Math.max(dp[1][i-1][0], dp[1][i-1][1]);
				}else if(j==1) {
					min=Math.min(dp[0][i-1][0], Math.min(dp[0][i-1][1], dp[0][i-1][2]));
					max=Math.max(dp[1][i-1][0], Math.max(dp[1][i-1][1], dp[1][i-1][2]));
				}else {
					min=Math.min(dp[0][i-1][1], dp[0][i-1][2]);
					max=Math.max(dp[1][i-1][1], dp[1][i-1][2]);
				}
				dp[0][i][j]=map[i][j]+min;
				dp[1][i][j]=map[i][j]+max;
			}
		}
		min=Math.min(dp[0][N-1][0], Math.min(dp[0][N-1][1], dp[0][N-1][2]));
		max=Math.max(dp[1][N-1][0], Math.max(dp[1][N-1][1], dp[1][N-1][2]));
		System.out.println(max+" "+min);
	}


}
