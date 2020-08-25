package BOJ.sds_algo.day05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 *  DP
 *  점화식
 */
public class B5569_출근경로 {
	static int W, H, dp [][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		W=Integer.parseInt(token.nextToken());
		H=Integer.parseInt(token.nextToken());
		dp=new int[H][W][2];

		dp[0][0][0]=1; dp[0][0][1]=1;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(i==0 && j==0) continue;

				int h=j-1<0?0:dp[i][j-1][0], v=i-1<0?0:dp[i-1][j][1];
				int hh=j-2<0?0:dp[i][j-2][0], vv=i-2<0?0:dp[i-2][j][1];
				if(i==0 || j==0) {
					vv=v; hh=h;
				}
				dp[i][j][0]=(h+vv)%100000;
				dp[i][j][1]=(v+hh)%100000;
				
				/*
				 * dp[i][j][0] -= ((i-1<0?0:dp[i-1][j][1])-(i-2<0?0:dp[i-2][j][1]))%100000;
				 * dp[i][j][1] -= ((j-1<0?0:dp[i][j-1][0])-(j-2<0?0:dp[i][j-2][0]))%100000;
				 */
			}
		}
		System.out.println((dp[H-1][W-1-1][0]+dp[H-1-1][W-1][1])%100000);

	}

}
