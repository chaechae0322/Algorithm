package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 위상정럴
 * 시작점 처음부터 다 넣고 해야한다
 */
public class B1005_ACMCraft {
	
	static int n, d[], in[], g[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		int tc=Integer.parseInt(br.readLine());
		loop: for(int t=1; t<=tc; t++) {
			token = new StringTokenizer(br.readLine());
			n=Integer.parseInt(token.nextToken());
			int k=Integer.parseInt(token.nextToken());
			token = new StringTokenizer(br.readLine()); // d
			
			d=new int[n+1]; g=new int[n+1][n+1]; in=new int[n+1];
			for(int i=1; i<=n; i++) {
				d[i]=Integer.parseInt(token.nextToken());
			}
			for(int i=0; i<k; i++) {
				token = new StringTokenizer(br.readLine());
				int src=Integer.parseInt(token.nextToken());
				int dst=Integer.parseInt(token.nextToken());
				in[dst]++;
				g[src][dst]=1;
			}
			int target = Integer.parseInt(br.readLine());
			System.out.println(topologicalSort(target));
		}
	}
	private static int topologicalSort(int target) {
		int[] visited=new int[n+1];
		Queue<int[]> q= new LinkedList<int[]>();
		for(int i=1; i<=n; i++) {
			if(in[i]==0) {
				visited[i]=d[i];
				q.add(new int[] {i, d[i]});
			}
		}
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			if(tmp[0]==target) {
				return tmp[1];
			}
			
			for(int i=1; i<=n; i++) {
				if(g[tmp[0]][i]!=0) {
					in[i]--;
					if(tmp[1]+d[i]>visited[i]) visited[i]=tmp[1]+d[i];
					if(in[i]==0) {
						q.add(new int[] {i, visited[i]});
					}
				}
			}
		}
		return -1;
	}

}
