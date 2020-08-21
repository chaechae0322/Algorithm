package BOJ.sds_algo.day05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5569_출근경로 {
	static int W, H;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		W=Integer.parseInt(token.nextToken());
		H=Integer.parseInt(token.nextToken());
		
		dp=new long[H+W][H+W];
		dp[0][0]=0; dp[1][0]=1; dp[1][1]=1; 
		//dp[2][0]=1; dp[2][1]=2;
		
		combi(H+W-1, W-1);
		System.out.println(dp[W+H-1][W-1]);
		
		
		for(int i=0; i<H+W; i++)
			System.out.println(Arrays.toString(dp[i]));
		
	}
	public static void combi(int n, int k) {
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=i; j++) {
				//
				if(j==0||j==i) {
					dp[i][j]=1;
					continue;
				}
				
				if(i-3>=0 && j-2>=0 && dp[i-3][j-2]!=0) {
					//System.out.println("wrong path left");
					dp[i-2][j-1]-=dp[i-3][j-2];
					dp[i-1][j-1]-=dp[i-3][j-2];
					dp[i-3][j-2]=0;
				}
				if(i-3>=0 && j-1>=0 && dp[i-3][j-1]!=0) {
					//System.out.println("wrong path right");
					dp[i-2][j-1]-=dp[i-3][j-1];
					dp[i-1][j]-=dp[i-3][j-1];
					dp[i-3][j-1]=0;
				}
				
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
				
				//for(int ii=0; ii<=i; ii++)
				//	System.out.println(Arrays.toString(dp[ii]));
				System.out.println("i:"+i+" j:"+j+" 경로:"+dp[i][j]);
				
			}
		}
	}
	
	private static long combiRecur(int n, int k) {
		//System.out.println("n:"+n+" k:"+k);
		
		if(dp[n][k]!=0) return dp[n][k];
		
		if(k==0||k==n) {
			dp[n][k]=1;
			return dp[n][k];
		}
		
		else {
			if(n>=3 && k>=2) {
				//
			}else {
				dp[n][k]=(combiRecur(n-1,k-1)+combiRecur(n-1, k))%100000;
			}

			return dp[n][k];
		}
		
	}

}
