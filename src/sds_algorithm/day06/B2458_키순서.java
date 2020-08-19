package sds_algorithm.day06;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2458_키순서 {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(token.nextToken());
		M=Integer.parseInt(token.nextToken());
		map=new int[N+1][N+1];
		
		int a=0, b=0;
		for(int i=0; i<M; i++) {
			token = new StringTokenizer(br.readLine());
			a=Integer.parseInt(token.nextToken());
			b=Integer.parseInt(token.nextToken());
			map[a][b]=1;
		}
		
		int res=0, ans=0;
		boolean[] visited= new boolean[N+1];
		
		int big=0, small=0;
		dp=new int[2][N+1];
		for(int i=1; i<=N; i++) {
			visited= new boolean[N+1];
			visited[i]=true;
			res = bigger(i, visited) + smaller(i, visited);
			if(res==N-1) ans++;
		}
		System.out.println(ans);
	}
	static int[][] dp;
	private static int smaller(int n, boolean[] visited) {
		int res = 0;
		for(int i=1; i<=N; i++) {
			if(map[i][n]==1 && !visited[i]) {
				visited[i]=true;
				res += smaller(i, visited)+1;
				//visited[i]=false;
			}
		}
		return res;
	}
	private static int bigger(int n, boolean[] visited) {
		
		int res = 0;
		for(int i=1; i<=N; i++) {
			if(map[n][i]==1 && !visited[i]) {
				visited[i]=true;
				res += bigger(i, visited)+1;
				//visited[i]=false;
			}
		}
		return res;
	}

}
