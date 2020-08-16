package sds_algorithm.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5557_1학년 {
	static int[] arr;
	static boolean[] visited;
	static int len;
	static int zeroCount;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(token.nextToken());
		token = new StringTokenizer(br.readLine());
		arr=new int[N]; visited=new boolean[N];
		dp=new long[N+1][20+1];
		
		for(int i=0; i<N-1; i++) {
			int tmp=Integer.parseInt(token.nextToken());
			if(tmp==0&&i!=0) {
				zeroCount++;
			}else {
				arr[len++]=tmp;	
			}
		}
		arr[len++]=Integer.parseInt(token.nextToken());
		dp[1][arr[0]]=1;
		
		System.out.println(Arrays.toString(arr)+" length:"+len);
		
		if(len>1) {
			combi(1, arr[0]);
		}
		if(!find) dp[1][arr[0]]=0;
		dp[1][arr[0]]*=Math.pow(2, zeroCount);
		System.out.println(dp[1][arr[0]]);
	}
	static long ans;
	static long[][] dp;
	static boolean find;
	private static long combi(int pos, int res) {
		if(res<0 || res>20) return 0;
		if(dp[pos][res]!=0 && pos!=1) {
			System.out.println("dp hell yeah");
			return dp[pos][res];
		}
		
		System.out.println("pos:"+pos+" res:"+res+" visited:"+Arrays.toString(visited));
		
		if(pos==len-1) {
			if(res==arr[len-1]) {
				System.out.println(Arrays.toString(visited));
				find=true;
				dp[pos][res]=1;
				return dp[pos][res];
			}
			else return 0;
		}
		
		visited[pos]=true;
		dp[pos][res]=combi(pos+1, res+arr[pos]);
		visited[pos]=false;
		dp[pos][res]+=combi(pos+1, res-arr[pos]);
		
		return dp[pos][res];
	}

}
