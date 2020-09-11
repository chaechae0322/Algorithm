package Programmers;
/*
 * DP
 */
public class 보행자천국 {
	public static void main(String[] args) {
		int[][] citymap= {{0, 2, 0, 0, 0, 2},{0, 0, 2, 0, 1, 0},{1, 0, 0, 2, 2, 0}};
		System.out.println(solution(3,6,citymap));

	}
    static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp=new int[m][n][2]; //0 h, 1 v 
        dp[0][0][0]=1; dp[0][0][1]=0; 
        int h, v;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(i==0 && j==0) continue;
        		if(cityMap[i][j]==1) continue;
        		h=v=0;
        		if(j-1>=0) {
        			if(cityMap[i][j-1]==2) {
        				h=dp[i][j-1][0];
        			}else {
        				h=(dp[i][j-1][0]+dp[i][j-1][1])%MOD;
        			}
        		}
        		if(i-1>=0) {
        			if(cityMap[i-1][j]==2) {
        				v=dp[i-1][j][1];
        			}else {
        				v=(dp[i-1][j][0]+dp[i-1][j][1])%MOD;
        			}
        		}
        		dp[i][j][0]=h; dp[i][j][1]=v;
        	}
        }
        answer=(dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
        return answer;
    }

}
