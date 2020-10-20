package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 벡터합 : sqrt( (a1+b1)^2 + (a2+b2)^2 )
 * 조합
 */
public class B1007_벡터매칭 {
	static int vectors[][]; static double ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token;
		
		int tc=Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int n=Integer.parseInt(br.readLine());
			vectors=new int[n][2];
			for(int i=0; i<n; i++) {
				token = new StringTokenizer(br.readLine());
				vectors[i][0]=Integer.parseInt(token.nextToken());
				vectors[i][1]=Integer.parseInt(token.nextToken());
			}
			
			ans=Double.MAX_VALUE;
			boolean[] visited=new boolean[n];
			combi(0,visited,0,n/2);
			System.out.printf("%.12f\n", ans);
		}
	}
	private static void combi(int pos, boolean[] visited, int cnt, int k) {
		if(cnt==k) {
			vectorSum(visited);
			return;
		}
		if(pos==k*2) return;
		visited[pos]=true;
		combi(pos+1, visited, cnt+1, k);
		visited[pos]=false;
		combi(pos+1, visited, cnt, k);
	}
	private static void vectorSum(boolean[] visited) {
		long xsum=0, ysum=0;
		for(int i=0; i<visited.length; i++) {
			if(visited[i]) {
				xsum+=vectors[i][0];
				ysum+=vectors[i][1];
			}else {
				xsum-=vectors[i][0];
				ysum-=vectors[i][1];
			}
		}
		double res=Math.sqrt(xsum*xsum+ysum*ysum);
		if(ans>res) {
			ans=res;
		}
	}

}
