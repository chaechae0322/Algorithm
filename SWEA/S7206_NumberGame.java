package SWEA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class S7206_NumberGame {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());
		
		int tc=Integer.parseInt(token.nextToken());
		for(int t=1; t<=tc; t++) {
			String str=br.readLine();
			if(str.length()==1) {
				System.out.println("#"+t+" 0");
				continue;
			}
			
			maxturn=0;
			dp=new int[99999+1];
			int tmpturn=0;
			int su=Integer.parseInt(str);
			for(int i=1; i<str.length(); i++) {
				boolean[] visited=new boolean[str.length()-1];
				tmpturn=Math.max(tmpturn, dfs(0,0,i,str,visited,1, su)); 
			}
			dp[su]=tmpturn;
			//System.out.println(Arrays.toString(dp));
			System.out.println("#"+t+" "+dp[su]);
		}
	}
	static int maxturn;
	private static int dfs(int pos, int cnt, int limit, String str, boolean[] visited, int turn, int su) {

		if(dp[su]!=0) return dp[su];
		
		if(cnt==limit) {
			System.out.println(Arrays.toString(visited));
			System.out.println("str:"+str);
			
			int res=1;
			int st=0, en=0;
			int tmp=0;
			for(int i=0; i<visited.length; i++) {
				
				if(visited[i]) {
					en=i;
					tmp=Integer.parseInt(str.substring(st, en+1)); //시작위치, 끝위치
					res*=tmp;
					st=i+1;
					System.out.println("st:"+st+" en:"+en+" tmp:"+tmp);
				}
			}
			tmp=Integer.parseInt(str.substring(st)); //시작 위치
			res*=tmp;
			System.out.println("st:"+st+" en:"+en+" tmp:"+tmp);
			
			System.out.println("res:"+res);
			if(res>=10) {
				String nstr=Integer.toString(res);
				int tmpturn=0;
				for(int i=1; i<nstr.length(); i++) {
					boolean[] nvisited=new boolean[nstr.length()-1];
					tmpturn=Math.max(tmpturn, dfs(0,0,i,nstr,nvisited,turn+1,res)); 
					System.out.println("tmpturn:"+tmpturn+" res:"+res);
				}
				dp[res]=tmpturn;
				return dp[res];
			}else {
				System.out.println("turn:"+turn);
				//maxturn=Math.max(maxturn, turn);
				//dp[su]=Math.max(turn, dp[su]);
				return turn;
			}
			
			//return dp[su];
		}
		if(pos==visited.length) return 0;
		
		int res=0;
		visited[pos]=true;
		res=dfs(pos+1, cnt+1, limit, str, visited, turn, su);
		visited[pos]=false;
		res=Math.max(res, dfs(pos+1, cnt, limit, str, visited, turn, su));
		
		return res;
		
	}

}
