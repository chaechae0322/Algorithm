package SWEA;


import java.util.Scanner;

/*
 * 2020.03.05
 * SWEA 2814 최장경로
 */
public class 최장경로_2814 {
	static int N, M;
	static int[][] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			N=sc.nextInt(); M=sc.nextInt();
			graph=new int[N+1][N+1];
			for(int i=0; i<M; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				graph[a][b]=1;
				graph[b][a]=1;
			}
			
			ans=0;
			for(int i=1; i<=N; i++) {
				
				boolean[] visited=new boolean[N+1];
				visited[i]=true;
				dfs(i,1,visited);
			}
			
			System.out.println("#"+t+" "+ans);
		}

	}
	static int ans;
	private static void dfs(int pos, int cnt, boolean[] visited) {
		ans=Math.max(ans, cnt);
		
		for(int i=1; i<=N; i++) {
			if(graph[pos][i]!=0 && !visited[i]) {
				visited[i]=true;
				dfs(i, cnt+1, visited);
				visited[i]=false;
			}
		}
		
	}

}
