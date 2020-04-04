package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B10251_운전면허시험 {
	static int[][] map;
	static int[][][][] dp;
	static int[][] hori, vert;
	static int N,M,L,G;	
	static int maxTurn;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		int tc=Integer.parseInt(token.nextToken());
		for(int t=0; t<tc; t++) {
			token = new StringTokenizer(br.readLine());
			N=Integer.parseInt(token.nextToken());
			M=Integer.parseInt(token.nextToken());
			L=Integer.parseInt(token.nextToken());
			G=Integer.parseInt(token.nextToken());
			maxTurn=Math.min(N-1, M-1)*2+1;

			map=new int[N][M];
			dp=new int[N+M][2][N][M];
			for(int i=0; i<N+M; i++) 
				for(int j=0; j<2; j++)
					for(int k=0; k<N; k++)
						Arrays.fill(dp[i][j][k], Integer.MAX_VALUE-1001);
		
			
			hori=new int[N][M];
			vert=new int[N][M];
			for(int i=0; i<N; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<M-1; j++) {
					hori[i][j]=Integer.parseInt(token.nextToken());
				}
			}

			for(int i=0; i<N-1; i++) {
				token = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					vert[i][j]=Integer.parseInt(token.nextToken());
				}
			}

			dp[0][0][0][1]=hori[0][0];
			dp[0][1][1][0]=vert[0][0];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(i==0&&j==0 || i==N-1&&j==M-1) continue;
					System.out.println("i:"+i+" j:"+j);

					for(int k=0; k<=Math.min(i, j)*2+1; k++) {

						//if(dp[k][0][i][j]!=Integer.MAX_VALUE) {
							if(j+1<M) {
								//if(dp[k][0][i][j+1]!=0)
									dp[k][0][i][j+1]=Math.min(dp[k][0][i][j+1], dp[k][0][i][j]+hori[i][j]);
									dp[k+1][0][i][j+1]=Math.min(dp[k+1][0][i][j+1], dp[k][1][i][j]+hori[i][j]);
								//else dp[k][0][i][j+1]=dp[k][0][i][j]+hori[i][j];
							}
							if(i+1<N) {
								//if(dp[k+1][1][i+1][j]!=0)
									dp[k+1][1][i+1][j]=Math.min(dp[k+1][1][i+1][j], dp[k][0][i][j]+vert[i][j]);
									dp[k][1][i+1][j]=Math.min(dp[k][1][i+1][j], dp[k][1][i][j]+vert[i][j]);
								//else dp[k+1][1][i+1][j]=dp[k][0][i][j]+vert[i][j];
							}
					}
				}
			}

			//if(t==2) {
				for(int k=0; k<maxTurn; k++) {
					System.out.println(k+"번 꺾음");
					for(int i=0; i<N; i++) {
						for(int j=0; j<M; j++)
							System.out.print(dp[k][0][i][j]+" ");
						System.out.println();
					}
					System.out.println();
				}
			//}


			int ans=-1;
			for(int i=0; i<maxTurn; i++) {
				if((dp[i][0][N-1][M-1]<=G) || (dp[i][1][N-1][M-1]<=G)) {
					ans=(N+M-2)*L+i; break;
				}
			}
			System.out.println(ans);
		}

	}

}
