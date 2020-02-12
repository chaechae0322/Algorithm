import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14501_Main {
	static int n;
	static int[] T;
	static int[] P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		n=Integer.parseInt(token.nextToken());
		T=new int[n];
		P=new int[n];
		
		for(int i=0; i<n; i++) {
			token = new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(token.nextToken());
			P[i]=Integer.parseInt(token.nextToken());
		}
		//System.out.println(Arrays.toString(T));
		//System.out.println(Arrays.toString(P));
		
		boolean[] visited=new boolean[n];
		dfs(0,0,visited);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int pos, int cost, boolean[] visited) {
		if(pos>=n) {
			ans=Math.max(cost, ans);
			return;
		}
		
		if(pos+T[pos] <= n) {
			visited[pos]=true;
			dfs(pos+T[pos], cost+P[pos],visited);
		}
		visited[pos]=false;
		dfs(pos+1, cost, visited);
	}

}
