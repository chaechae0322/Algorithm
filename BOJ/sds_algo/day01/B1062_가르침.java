package BOJ.sds_algo.day01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class B1062_가르침 {
	static int N,K;
	static boolean[] visited;
	static String[] input;
	public static void main(String[] args) throws FileNotFoundException {
		
		//System.setIn(new FileInputStream("src\\DAY01\\P1062\\input.txt"));
		
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt(); K=sc.nextInt();
		if(K<5) {
			System.out.println("0");
			return;
		}
		visited=new boolean[26];
		input=new String[N];
		for(int i=0; i<N; i++) {
			input[i]=sc.next();
		}
		visited['a'-'a']=true;
		visited['n'-'a']=true;
		visited['t'-'a']=true;
		visited['i'-'a']=true;
		visited['c'-'a']=true;
		dfs(0,0);
		System.out.println(ans);
	}
	static int ans;
	private static void dfs(int pos, int cnt) {
		
		if(cnt==K-5) {
			//System.out.println(Arrays.toString(visited));
			/*for(int i=0; i<26; i++) {
				if(visited[i]) System.out.print((char)('a'+i));
			}
			System.out.println();*/
			boolean flag=true;
			int res=0;
			loop: for(int i=0; i<N; i++) {
				flag=true;
				for(int j=0; j<input[i].length(); j++) {
					//System.out.println(input[i].charAt(j));
					if(!visited[input[i].charAt(j)-'a']) {
						flag=false;
						continue loop;
					}
				}
				if(flag) res++;

			}
			ans=Math.max(res, ans);
			return;
		}
		if(pos==26) return;

		if(pos=='a'-'a'||pos=='n'-'a'||pos=='t'-'a'||pos=='i'-'a'||pos=='c'-'a') {
			dfs(pos+1, cnt);
		}
		else {
			visited[pos]=true;
			dfs(pos+1, cnt+1);
			visited[pos]=false;
			dfs(pos+1, cnt);
		}
	}

}
