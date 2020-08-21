package SWEA;
import java.util.Scanner;

public class ChonSu {
	static int n;
	static int src;
	static int dst;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		src=sc.nextInt();
		dst=sc.nextInt();

		map=new int[n+1][n+1];
		visited=new boolean[n+1];
		
		int con=sc.nextInt();
		for(int i=0; i<con; i++) {
			int k=sc.nextInt();
			int j=sc.nextInt();
			
			map[k][j]=1;
			map[j][k]=1;
		}
	
		dfs(src, 0);
		if(!find)
			System.out.println("-1");

	}
	static boolean find=false;
	static void dfs(int src, int ans) {

		
		if(src == dst) {
			find=true;
			System.out.println(ans);
			return;
		}
		
		visited[src]=true;
		for(int i=1; i<=n; i++) {
			if(map[src][i]==1 && !visited[i]) {
				dfs(i, ans+1);
	
			}
		}

	}

}