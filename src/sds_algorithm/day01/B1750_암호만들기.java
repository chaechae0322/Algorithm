package sds_algorithm.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B1750_암호만들기 {

	static int L,C;
	static char[] alpha;
	static boolean[] visited;
	//static StringBuilder sb;
	static ArrayList<String> ans;
	static char[] res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L=sc.nextInt(); C=sc.nextInt();
		alpha=new char[C];
		visited=new boolean[C];
		res=new char[L];
		ans=new ArrayList<>();
		for(int i=0; i<C; i++)
			alpha[i]=sc.next().charAt(0);
		dfs(0,0);
		Collections.sort(ans);
		for(String s:ans)
			System.out.println(s);

	}
	private static void dfs(int pos, int cnt) {
		//System.out.println(Arrays.toString(res));
		if(cnt==L) {
			int mo=0;
			int ja=0;
			for(int i=0; i<C; i++) {
				if(visited[i]) {
					if(alpha[i]=='a'||alpha[i]=='e'||alpha[i]=='i'||alpha[i]=='o'||alpha[i]=='u') {
						mo++;
					}else {
						ja++;
					}
				}
			}
			if(mo>=1&&ja>=2) {
				char[] tmp = res.clone();
				Arrays.sort(tmp);
				StringBuilder sb= new StringBuilder();
				
				for(char c : tmp)
					sb.append(c);
				ans.add(sb.toString());
			}
			
			return;
		}
		if(pos==C) return;
		
		visited[pos]=true;
		res[cnt]=alpha[pos];
		dfs(pos+1, cnt+1);
		visited[pos]=false;
		res[cnt]='\u0000';
		dfs(pos+1, cnt);
	}

}
