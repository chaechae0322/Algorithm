package jungol;

import java.util.Arrays;
import java.util.Scanner;

public class CrossRockBrige {
	static char[] tar;
	static char[][] br;
	static int tarn;
	static int brn;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line=sc.next();
		tar=new char[line.length()];
		tar=line.toCharArray();
		tarn=tar.length;
		
		br=new char[2][];
		
		line=sc.next();
		brn=line.length();
		br[0]=new char[line.length()];
		br[1]=new char[line.length()];
		
		br[0]=line.toCharArray();
		
		line=sc.next();
		br[1]=line.toCharArray();
		
		
		boolean[] visited=new boolean[br[0].length];
		
		dfs(-1,0,visited,0); //idx, depth, visited
		dfs(-1,0,visited,1);
		
		System.out.println(ans);
	}
	static int ans;
	static void dfs(int idx, int depth, boolean[] visited, int sel) {
		if(brn-1-idx < tarn-depth) return;
		if(depth == tarn) {
			ans+=1;
			return;
		}
		
		for(int i=idx+1; i<brn; i++) {
			if(br[sel][i] == tar[depth] && !visited[i]) {
//				System.out.println("sel:"+sel+" depth:"+depth+" what:"+br[sel][i]);
				visited[i]=true;
				dfs(i,depth+1, visited, sel==1?0:1);
				visited[i]=false;
			}
			
		}
		
	}
	
	

}
