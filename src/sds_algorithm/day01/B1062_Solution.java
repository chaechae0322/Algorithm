package sds_algorithm.day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B1062_Solution {

	static int N,K;
	static boolean[] visited;
	static String[] words;
	static int selectedCount;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\sds_algorithm\\day01\\p1062_input.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); K=sc.nextInt();
		visited=new boolean[26];
		words=new String[N];

		visited['a'-'a']=true;
		visited['n'-'a']=true;
		visited['t'-'a']=true;
		visited['i'-'a']=true;
		visited['c'-'a']=true;
		selectedCount=5;

		for(int i=0; i<N; i++) {
			words[i]=sc.next().replaceAll("[antic]", "");
		}

		dfs(0);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int pos) {
		visited[pos]=true;
		selectedCount++;
		
		if(selectedCount==K) {
			boolean flag=true;
			int res=0;
			loop: for(int i=0; i<N; i++) {
				flag=true;
				for(int j=0; j<words[i].length(); j++) {
					if(!visited[words[i].charAt(j)-'a']) {
						flag=false;
						continue loop;
					}
				}
				if(flag) res++;

			}
			ans=Math.max(res, ans);
			return;
		}else {
			for(int i=pos+1; i<26; i++) {
				if(!visited[i]) {
					dfs(i);
					
				}
			}
		}
		visited[pos]=false;
		selectedCount--;
	}

}
